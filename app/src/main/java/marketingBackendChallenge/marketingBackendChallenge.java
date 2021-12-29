/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marketingBackendChallenge;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.HttpsURLConnection;
import org.jfree.chart.ChartFrame;

/**
 *
 * @author L
 */
public class marketingBackendChallenge {
    
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "GOOGLE SHEETS";
    private static String SPREADSHEET_ID ="1KXpzYO7uIC_B_H2Ivp2giEat-sQ_upDjyeG25VrXGSQ";
    
            
    private static Credential authorize() throws IOException, GeneralSecurityException{
        
        InputStream in = marketingBackendChallenge.class.getResourceAsStream("/credentials.json");
        
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                   GsonFactory.getDefaultInstance(), new InputStreamReader(in)
        );
        
        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        
        Credential credential = new AuthorizationCodeInstalledApp(
                flow,new LocalServerReceiver())
                .authorize("user");
        
        return credential; 
    }
    
    public static Sheets getSheetsService() throws GeneralSecurityException, IOException{
        
       Credential credential = authorize();
       return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(), credential)
               .setApplicationName(APPLICATION_NAME)
               .build();
        
    }
    
  
    
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        
        
        
        
        
        sheetsService = getSheetsService();
        String range = "marketing_campaign";
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();
        List<List<Object>> values = response.getValues();
        
        Costumers costumers = new Costumers(values);
        
        
        ChartFrame view57 = costumers.getCostumers57to67();
        view57.setLocation(0, 0);
        view57.setVisible(true);
        
        ChartTeens viewTeens = new ChartTeens(costumers);
        viewTeens.setLocation(500,0);
        viewTeens.setVisible(true);
        
        ChartKids viewKids = new ChartKids(costumers);
        viewKids.setLocation(1000, 0);
        viewKids.setVisible(true);
        
        
        
        
    
    }
}
