/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import dtos.BoredDTO;
import dtos.CatFactsDTO;
import dtos.KoalaFactDTO;
import dtos.KoalaImgDTO;
import dtos.MyIPDTO;
import dtos.SpaceDTO;
import dtos.TrumpQuotesDTO;
import java.io.IOException;
import utils.HttpUtils;

/**
 *
 * @author GRP 5
 */
public class DataFetcherFacade {
    
    public DataFetcherFacade() {

    }

    public BoredDTO getBoredDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://www.boredapi.com/api/activity/");
        BoredDTO boredDTO = gson.fromJson(jasonString, BoredDTO.class);

        return boredDTO;
    }

    public CatFactsDTO getCatFactsDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://catfact.ninja/fact");
        CatFactsDTO catFactsDTO = gson.fromJson(jasonString, CatFactsDTO.class);

        return catFactsDTO;
    }

    public MyIPDTO getMyIPDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://api.ipify.org?format=json");
        MyIPDTO myIPDTO = gson.fromJson(jasonString, MyIPDTO.class);

        return myIPDTO;
    }

    public SpaceDTO getSpaceDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("http://api.open-notify.org/astros.json");
        SpaceDTO spaceDTO = gson.fromJson(jasonString, SpaceDTO.class);

        return spaceDTO;
    }

    public TrumpQuotesDTO getTrumpQuotesDTO() throws IOException {

        Gson gson = new Gson();
        String jasonString = HttpUtils.fetchData("https://api.whatdoestrumpthink.com/api/v1/quotes/random");
        TrumpQuotesDTO trumpQuotesDTO = gson.fromJson(jasonString, TrumpQuotesDTO.class);

        return trumpQuotesDTO;
    }
    
    public KoalaFactDTO getKoalaFact() throws IOException {
         Gson gson = new Gson();
         String jsonString = HttpUtils.fetchData("https://some-random-api.ml/facts/koala");
         KoalaFactDTO koalaFactDTO = gson.fromJson(jsonString, KoalaFactDTO.class);
        
        return koalaFactDTO;
    }
    
    public KoalaImgDTO getKoalaLink() throws IOException {
        Gson gson = new Gson();
        String jsonString = HttpUtils.fetchData("https://some-random-api.ml/img/koala");
        KoalaImgDTO koalaImgDTO = gson.fromJson(jsonString, KoalaImgDTO.class);
        return koalaImgDTO;
    }

}
