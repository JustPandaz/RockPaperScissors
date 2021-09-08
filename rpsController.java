package rps.panda.org;

import animatefx.animation.ZoomIn;
import io.github.palexdev.materialfx.controls.MFXLabel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.concurrent.ThreadLocalRandom;

public class rpsController {

    int player1, player2, score, attemptsLeft = 3;

    @FXML
    Button btnPlay;
    @FXML
    Button btnExit;
    @FXML
    Button btnRock;
    @FXML
    Button btnAgain;
    @FXML
    Button btnPaper;
    @FXML
    Button btnScissors;
    @FXML
    ImageView btnBack;
    @FXML
    Pane mainMenuPane;
    @FXML
    Pane gamePane;
    @FXML
    Pane resultsPane;
    @FXML
    Pane againPane;
    @FXML
    Pane oneRock;
    @FXML
    Pane onePaper;
    @FXML
    Pane oneScissors;
    @FXML
    Pane twoRock;
    @FXML
    Pane twoScissors;
    @FXML
    Pane twoPaper;
    @FXML
    MFXLabel scoreLabel;
    @FXML
    Label resultLabel;

    public void playButtonClicked() {

        new ZoomIn(gamePane).setSpeed(10).play();
        gamePane.toFront();
    }

    public void exitButtonClicked() {

        boolean result = AlertBox.yesPopup("Rock Paper Scissors", "Are you sure you want to exit?");

        if(result) {
            System.exit(0);
        }
    }

    public void backButtonClicked() {

        new ZoomIn(mainMenuPane).setSpeed(10).play();
        mainMenuPane.toFront();
    }

    public void rockButtonClicked() {

        new ZoomIn(resultsPane).setSpeed(10).play();
        resultsPane.toFront();

        oneRock.toFront();

        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        player1 = 1;
        player2 = randomNum;

        if(randomNum == 1) {

            twoRock.toFront();
        } else if(randomNum == 2) {

            twoPaper.toFront();
        } else {

            twoScissors.toFront();
        }

        Checks();
    }

    public void paperButtonClicked() {

        new ZoomIn(resultsPane).setSpeed(10).play();
        resultsPane.toFront();

        onePaper.toFront();

        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        player1 = 2;
        player2 = randomNum;

        if(randomNum == 1) {

            twoRock.toFront();
        } else if(randomNum == 2) {

            twoPaper.toFront();
        } else {

            twoScissors.toFront();
        }

        Checks();
    }

    public void scissorsButtonClicked() {

        new ZoomIn(resultsPane).setSpeed(10).play();
        resultsPane.toFront();

        oneScissors.toFront();

        int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        player1 = 3;
        player2 = randomNum;

        if(randomNum == 1) {

            twoRock.toFront();
        } else if(randomNum == 2) {

            twoPaper.toFront();
        } else {

            twoScissors.toFront();
        }

        Checks();
    }

    public void againButtonClicked() {

        new ZoomIn(gamePane).setSpeed(10).play();
        gamePane.toFront();
    }

    void Checks() {

        if(player1 == player2) {
            AlertBox.okPopup("Rock Paper Scissors!" , "Draw!");
        }
        if(player1 == 1 && player2 == 2) {

            AlertBox.okPopup("Rock Paper Scissors!" , "You lost!");

            score--;
            scoreLabel.setText("Score: " + score);
        }
        if(player1 == 1 && player2 == 3) {

            AlertBox.okPopup("Rock Paper Scissors!" , "You won!");

            score++;
            scoreLabel.setText("Score: " + score);
        }
        if(player1 == 2 && player2 == 1) {

            AlertBox.okPopup("Rock Paper Scissors!" , "You won!");

            score++;
            scoreLabel.setText("Score: " + score);
        }
        if(player1 == 2 && player2 == 3) {

            AlertBox.okPopup("Rock Paper Scissors!" , "You lost!");

            score--;
            scoreLabel.setText("Score: " + score);
        }
        if(player1 == 3 && player2 == 1) {

            AlertBox.okPopup("Rock Paper Scissors!" , "You lost!");

            score--;
            scoreLabel.setText("Score: " + score);
        }
        if(player1 == 3 && player2 == 2) {

            AlertBox.okPopup("Rock Paper Scissors!" , "You won!");

            score++;
            scoreLabel.setText("Score: " + score);
        }

        attemptsLeft--;
        scoreLabel.setText("Score: " + score);

        if(attemptsLeft == 0) {

            if(score >= 2) {

                resultLabel.setText("You Won!");
            } else {

                resultLabel.setText("You Lost!");
            }

            new ZoomIn(againPane).setSpeed(10).play();
            againPane.toFront();
            score = 0;
            scoreLabel.setText("Score: " + score);
            attemptsLeft = 3;
        }
    }
}
