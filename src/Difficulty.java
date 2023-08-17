public class Difficulty {

    public static final int EASY = 0;
    public static final int MEDIUM = 1;
    public static final int HARD = 2;

    public static String getDifficultyName(int difficulty) {
        switch (difficulty) {
            case EASY:
                return "Easy";
            case MEDIUM:
                return "Medium";
            case HARD:
                return "Hard";
            default:
                return "Unknown";
        }
    }

    public static void setDifficultyVelocities(int difficulty) {
        switch (difficulty) {
            case EASY:
                Integer[] easyBallSpeedX = { -9, 9 };
                Integer[] easyBallSpeedY = { -9, 9 };
                Ball.setPossibleSpeedX(easyBallSpeedX);
                Ball.setPossibleSpeedY(easyBallSpeedY);
                Player.setBASIC_VEL(14);
                Player.setBOT_VEL(9);
                break;
            case MEDIUM:
                Integer[] mediumBallSpeedX = { -10, 10 };
                Integer[] mediumBallSpeedY = { -10, 10 };
                Ball.setPossibleSpeedX(mediumBallSpeedX);
                Ball.setPossibleSpeedY(mediumBallSpeedY);
                Player.setBASIC_VEL(9);
                Player.setBOT_VEL(9);
                break;
            case HARD:
                Integer[] hardBallSpeedX = { -11, 11 };
                Integer[] hardBallSpeedY = { -11, 11 };
                Ball.setPossibleSpeedX(hardBallSpeedX);
                Ball.setPossibleSpeedY(hardBallSpeedY);
                Player.setBASIC_VEL(8);
                Player.setBOT_VEL(10);
                break;
        }
    }
}
