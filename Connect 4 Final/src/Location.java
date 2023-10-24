public class Location {

    private int status;
    // No tile = 0
    // Tile 1 = 1
    // Tile 2 = 2

    public Location() {
        status = 0;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusName() {
        if (status == 0) {
            return "-";
        }
        else if (status == 1) {
            return "X";
        }
        else if (status == 2) {
            return "O";
        }
        else if (status == 3) {
            return "C";
        }
        else {
            return "Error";
        }
    }

    public void setStatus(int stat) {
        status = stat;
    }


}