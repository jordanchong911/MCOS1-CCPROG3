public class lot {
    private tile[][] tiles;
    private int Rows;
    private int Columns;

    public lot() {
        Rows = 1;
        Columns = 1;
        //declare and occupy boxes with plot
        tiles = new tile[Rows][Columns];
        for(int i = 0; i < Rows; i++)
            for(int j = 0; j < Columns; j++)
                tiles[i][j] = new tile();
    }

    public tile getTile(int row, int column){
        return tiles[row][column];
    }
}
