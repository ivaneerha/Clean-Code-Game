package homework;

public class Player {
    private String name;
    private String score;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.score = "Love";
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public void increasePoints() {
        this.points++;
    }

    private void calculateScore() {
        switch (this.points) {
            case 0:
                this.score = Game2.SCORE_LOVE;
                break;
            case 1:
                this.score = Game2.SCORE_FIFTEEN;
                break;
            case 2:
                this.score = Game2.SCORE_THIRTY;
                break;
            case 3:
                this.score = Game2.SCORE_FORTY;
                break;
            default:
                this.score = Game2.EMPTY_STRING;
                break;
        }
    }

    public String getScore() {

        this.calculateScore();
        return this.score;
    }

    public boolean isWinning(Player player){
        return this.points >= Game2.BORDER_SCORE && (this.points - player.getPoints()) >= 2;
    }

    public boolean hasAdvantage(Player player) {
        return  (this.points > player.getPoints() && player.getPoints() > Game2.BORDER_SCORE);
    }

}
