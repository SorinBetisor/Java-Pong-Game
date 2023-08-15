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

    public static void setDifficultyVelocities(int difficulty)
    {
        switch(difficulty)
        {
            case EASY:
                return;
            case MEDIUM:
                return;
            case HARD:
                return;
        }
    }
}
