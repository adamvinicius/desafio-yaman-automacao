/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seleniumteste;

import com.metodos.MetodosSelenium;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author adamvinicius@gmail.com
 */
public class SeleniumTeste {
        private static WebDriver driver;
        private static MetodosSelenium umMetodo;
        private static MercadoLivre umMercadoLivre;
        private static List<String> listaMercadoLivre;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        umMetodo = new MetodosSelenium();
        umMercadoLivre = new MercadoLivre();
       
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        
        driver = new ChromeDriver();
        
        String url = "https://www.mercadolivre.com.br";
             
        
        try {

           umMetodo.setBaseUrl(url);
	   umMetodo.maximiza(driver);
          
          //1 - Realizar uma pesquisa no site do mercado livre e imprimir SOMENTE título e valor dos CINCO primeiros resultados.
         
           umMercadoLivre.realizaPesquisa(driver, umMetodo, "Star Wars");
           umMercadoLivre.setDadosMercadoLivre(driver, umMetodo, 5);
           listaMercadoLivre = umMercadoLivre.retornaListaMercadolivre();
         
            for (int i = 0; i < listaMercadoLivre.size(); i++) {
                System.out.println(listaMercadoLivre.get(i));
            }
           
          //2 - Realizar uma pesquisa no site do mercado livre que contenha paginação, tirar um print do penúltimo anuncio da segunda página. 
          
           umMercadoLivre.realizaPesquisa(driver, umMetodo, "Star Wars");
           umMercadoLivre.tiraPrintPenultimoProduto(driver, umMetodo);
      
           
           driver.close();
           
        } catch (Exception e) {
            System.err.print(e);
            umMetodo.setErro(true);
            umMetodo.setLogErro("Não foi possível inicar o driver!!");
            
        }
        
        
        
        
    }
    
}
