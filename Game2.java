package homework;


public class Game2 {

    public static final String SCORE_LOVE = "Love";
    public static final String SCORE_FORTY = "Forty";
    public static final String SCORE_THIRTY = "Thirty";
    public static final String SCORE_FIFTEEN = "Fifteen";
    public static final int BORDER_SCORE = 4;
    public static final String FIRST_PLAYER_NAME = "Pesho";
    public static final String SECOND_PLAYER_NAME = "Gosho";
    public static final String GAME_SCORE_ADVANTAGE = "Advantage ";
    public static final String GAME_SCORE_WIN = "Win for ";
    public static final String EMPTY_STRING = "";
    private final Player firstPlayer;
    private final Player secondPlayer;

    public Game2(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

    }

    public String getScore() {

        String gameScore = EMPTY_STRING;

        String equalsScoreCheck = checkForEqualScore();
        if (!equalsScoreCheck.equals(EMPTY_STRING)) {
            gameScore = equalsScoreCheck;
            return gameScore;
        }

        if (this.firstPlayer.getPoints() < BORDER_SCORE && this.secondPlayer.getPoints() < BORDER_SCORE) {
            gameScore = this.firstPlayer.getScore() + " - " + this.secondPlayer.getScore();
            return gameScore;
        }

        String checkForAdvantagePlayer = checkForAdvantagePlayer();
        if (!checkForAdvantagePlayer.equals(EMPTY_STRING)) {
            gameScore = GAME_SCORE_ADVANTAGE + checkForAdvantagePlayer;
        }

        String checkedWinner = checksForWinner();
        if (!checkedWinner.equals(EMPTY_STRING)) {
            gameScore = checkedWinner;
        }

        return gameScore;
    }

    private String checksForWinner() {

        if (this.firstPlayer.isWinning(this.secondPlayer)) {

            return GAME_SCORE_WIN + firstPlayer.getName();

        }

        if (this.secondPlayer.isWinning(this.firstPlayer)) {

            return GAME_SCORE_WIN + secondPlayer.getName();

        }

        return EMPTY_STRING;
    }

    private String checkForEqualScore() {

        int pointsOnFirstPlayer = this.firstPlayer.getPoints();
        int pointsOnSecondPlayer = this.secondPlayer.getPoints();
        String scorePlayerOne = firstPlayer.getScore();

        String result = EMPTY_STRING;

        if (pointsOnFirstPlayer == pointsOnSecondPlayer) {
            result = scorePlayerOne;
            if (result.equals(EMPTY_STRING) || result.equals(SCORE_FORTY)) {
                result = "Deuce";
            } else {
                result += " All";
            }
        }

        return result;
    }


    private String checkForAdvantagePlayer() {

        if(this.firstPlayer.hasAdvantage(this.secondPlayer)){
            return this.firstPlayer.getName();
        }

        if(this.secondPlayer.hasAdvantage(this.firstPlayer)){
            return this.secondPlayer.getName();
        }

        return EMPTY_STRING;
    }



    public static void main(String[] args) {

        Player player1 = new Player(FIRST_PLAYER_NAME);
        Player player2 = new Player(SECOND_PLAYER_NAME);
        Game2 game = new Game2(player1, player2);

        player1.increasePoints();
        player2.increasePoints();
        player2.increasePoints();


        System.out.println(game.getScore());

    }

}