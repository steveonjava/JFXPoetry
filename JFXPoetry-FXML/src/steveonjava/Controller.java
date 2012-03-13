package steveonjava;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * @author Stephen Chin <steveonjava@gmail.com>
 */
public class Controller implements Initializable {    
    private TranslateTransition translate;    
    private FadeTransition fade;
    private MediaPlayer mediaPlayer;
    
    @FXML
    private Text text;
    
    @FXML
    private Image image;
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private Button button;
    
    @FXML
    private void replay(ActionEvent event) {
        fade.playFromStart();
        translate.playFromStart();
        mediaPlayer.stop();
        mediaPlayer.play();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        translate = TranslateTransitionBuilder.create()
                .duration(Duration.seconds(24))
                .node(text)
                .fromY(image.getHeight())
                .toY(0)
                .interpolator(Interpolator.EASE_OUT)
                .build();
        translate.play();
        
        fade = FadeTransitionBuilder.create()
                .duration(Duration.seconds(5))
                .node(imageView)
                .fromValue(0)
                .toValue(1)
                .interpolator(Interpolator.EASE_OUT)
                .build();
        fade.play();
        
        button.visibleProperty().bind(translate.statusProperty().isEqualTo(Animation.Status.STOPPED));
        
        Media media = new Media("http://video.fws.gov/sounds/35indigobunting.mp3");
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }    
}
