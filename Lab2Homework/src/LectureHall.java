/**
 * Clasa LectureHall descrier o sala de curs ce are (sau nu) video proiector (caracteristica specifica).
 */

public class LectureHall extends Room {
    private boolean videoProj;

    public LectureHall(String newName, int newCap, boolean proj) {
        name = newName;
        if (newCap > 0)
            cap = newCap;
        else
            System.out.println("eroare capacitate");
        type = "LECTURE_HALL";
        videoProj=proj;
    }

    public boolean isVideoProj() {
        return videoProj;
    }

    public void setVideoProj(boolean newProj) {
        videoProj = newProj;
    }

}