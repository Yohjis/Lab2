import entity.*;
import entity.dto.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;


public class Main {
    private static final String URL = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public static void main(String[] args) {

        headers.setContentType(MediaType.APPLICATION_JSON);

        Realtor realtor1 = new Realtor( "Petrov", "Co company", "2121@mail.ru");
        List<Integer> quantities = Arrays.asList(4,5,1,46,2,88,7,22,3);

        Realtor realtor2 = new Realtor( "Jack", "Ma", "2121@mail.ua");

        //get estates from DB
        ResponseEntity<EstatesDTO> response2 = restTemplate
                .exchange(URL + "/getAllEstate", HttpMethod.GET, headersEntity, EstatesDTO.class);
        printEstates(Objects.requireNonNull(response2.getBody()).getEstates());

        //get estates from DB
        response2 = restTemplate
                .exchange(URL + "/getAllEstates", HttpMethod.GET, headersEntity, EstatesDTO.class);
        List<Estate> estatesForSale = Objects.requireNonNull(response2.getBody()).getEstates();
        printEstates(estatesForSale);

        Client client1 = new Client( "Pavel", "Banan", "12312@gmail.com");
        Client client2 = new Client( "Pavel", "Banan2", "12312@gmail.com");

        //creating deals
        System.out.println("Trying to create new deal");
        List<Estate> WishListForClient1 = new ArrayList<>(estatesForSale.subList(0, 2));
        makeDeal(client1, realtor1, WishListForClient1);

        System.out.println("Trying to create new deal");
        List<Estate> WishListForClient2 = new ArrayList<>(estatesForSale.subList(0, 2));
        WishListForClient2.add(estatesForSale.get(5));
        makeDeal(client2, realtor1, WishListForClient2);

        //get estates from DB
        response2 = restTemplate
                .exchange(URL + "/getAllEstates", HttpMethod.GET, headersEntity, EstatesDTO.class);
        printEstates(Objects.requireNonNull(response2.getBody()).getEstates());

        //get customers from DB
        ResponseEntity<ClientsDTO> response4 = restTemplate
                .exchange(URL + "/getAllClients", HttpMethod.GET, headersEntity, ClientsDTO.class);
        printClients(Objects.requireNonNull(response4.getBody()).getClient());

        ResponseEntity<DealsDTO> response5 = restTemplate
                .exchange(URL + "/getAllDeals", HttpMethod.GET, headersEntity, DealsDTO.class);
        printDeals(Objects.requireNonNull(response5.getBody()).getDeals());
    }

    private static void makeDeal(Client client, Realtor realtor, List<Estate> WishListForClient) {
        CreateDealDTO createDealDTO = new CreateDealDTO();
        createDealDTO.setClient(client);
        createDealDTO.setRealtor(realtor);
        createDealDTO.setEstates(WishListForClient);

        /*HttpEntity<CreateDealDTO> createDealDTO = new HttpEntity<DealsDTO>(createDealDTO);
        ResponseEntity<Void> response4 = restTemplate
                .exchange(URL + "/createDeal", HttpMethod.POST,
                        createDealDTO, Void.class);*/
    }

    public static List<Estate> createEstateList(Realtor realtor1) {

        Estate e1 = new Estate("1-01 metalistov 3", "room", 2000.0, realtor1);
        Estate e2 = new Estate("1-02 metalistov 3", "room", 4000.0, realtor1);
        Estate e3 = new Estate("1-03 metalistov 3", "room", 6000.0, realtor1);
        Estate e4 = new Estate("1-04 metalistov 3", "room", 1000.0, realtor1);
        Estate e5 = new Estate("1-05 metalistov 3", "room", 5000.0, realtor1);
        Estate e6 = new Estate("1-06 metalistov 3", "room", 5000.0, realtor1);
        Estate e7 = new Estate("1-07 metalistov 3", "room", 6000.0, realtor1);
        Estate e8 = new Estate("1-08 metalistov 3", "room", 1000.0, realtor1);
        Estate e9 = new Estate("1-09 metalistov 3", "room", 3000.0, realtor1);
        return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    }



    private static void printEstates(List<Estate> estates) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n___________________________________________");
        stringBuilder.append("\nEstates: ");
        for (Estate e : estates) {
            stringBuilder.append("\n").append(e);
        }
        stringBuilder.append("\n___________________________________________");

        System.out.println(stringBuilder.toString());
    }

    private static void printClients(List<Client> clients) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n___________________________________________");
        stringBuilder.append("\nClients: ");
        for (Client c : clients) {
            stringBuilder.append("\n").append(c);
        }
        stringBuilder.append("\n___________________________________________");

        System.out.println(stringBuilder.toString());
    }

    private static void printDeals(List<Deal> deals) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("___________________________________________").append("\nDeals: ");
        for (Deal d : deals) {
            stringBuilder.append("\n").append(d);
        }
        stringBuilder.append("\n___________________________________________");

        System.out.println(stringBuilder.toString());
    }

}