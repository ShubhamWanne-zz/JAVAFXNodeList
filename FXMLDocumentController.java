/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autocomplete;

import com.jfoenix.controls.JFXTextField;
import java.awt.Event;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author shubham
 */
public class FXMLDocumentController implements Initializable {
    
        static ArrayList<String> list = new ArrayList<String>();
    
    @FXML
    private JFXTextField input;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("---------------");
        String[] words = {"Hi","Hello","How re you","howdy","How !!"};
        try {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\shubham\\Desktop\\words.txt"));
            String line;
            while((line=in.readLine())!=null){
                list.add(line.trim());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TextFields.bindAutoCompletion(input, list);
        
    }    
        @FXML
    void getWords(ActionEvent event) {
            if(event.getSource().equals(Event.KEY_PRESS)){
                TextFields.bindAutoCompletion(input, list);
            }
    }
}
