import java.util.Arrays;

public class BingoCard {
  /*
    The two arrays are private and their structure is NEVER exposed to another
    class, which is why the getCardNumbers returns a String that needs
    further processing.

    While this is not computationally efficient, it is good programming
    practice to hide data structures (information hiding).
   */
  private int[][]     numbers;
  private boolean[][] markedOff;

  private int numberOfRows;
  private int numberOfColumns;

  public BingoCard(int numberOfRows, int numberOfColumns) {
    setNumberOfRows(numberOfRows);
    setNumberOfColumns(numberOfColumns);

    numbers   = new int[numberOfRows][numberOfColumns];
    markedOff = new boolean[numberOfRows][numberOfColumns];
    resetMarked();
  }

  public void resetMarked() {
    for (int i=0; i<this.markedOff.length;i++){
      for(int j=0; j<this.markedOff[i].length;j++){
        markedOff[i][j]=false;
      }

    }
    /* TODO
          Reset the data structure to be entirely false. Java defaults booleans
          to false so you can make use of that.
     */

  }
     /* TODO
           implement the getters and setters for rows / columns as seen below
     */
  public int getNumberOfRows() {
    /* TODO
          change the return from 0 to the appropriate return
     */
    return numberOfRows;
  }

  public void setNumberOfRows(int numberOfRows) {
    this.numberOfRows = numberOfRows;

  }

  public int getNumberOfColumns() {
    /* TODO
          change the return from 0 to the appropriate return
     */
    return numberOfColumns;
  }

  public void setNumberOfColumns(int numberOfColumns) {
    /* TODO
          implement code here
     */
    this.numberOfColumns = numberOfColumns;
  }

  public String getCardNumbers() {
    /* TODO
        flatten the numbers array into a single string with each number separated by spaces but no leading or trailing copies of
        that character: that is no spaces before the first number nor after the last number.
     */

    StringBuilder sb = new StringBuilder();
    /* TODO
          all the cards are stored as a grid ([][] numbers) of rows / columns, so for example, numbers 3 4 5 6 will be
          printed as follows:
          3  4
          5  6
     */
    /* TODO
          return the grid as a string
     */
    for(int i=0;i<numberOfRows;i++){
      for(int j=0;j<numberOfColumns;j++){
        sb.append(numbers[i][j]);
        if(j<numberOfColumns-1) {
          sb.append(Defaults.getNumberSeparator());
          if (numbers[i][j] < 10)
            sb.append(" ");
        }
      }
      sb.append("\n");
    }
    return sb.toString().trim();
  }

  public void setCardNumbers(String[] numbersAsStrings) {
    /* TODO
          the array of strings [] numbersAsStrings is cast to an integer as [] numbersList, for you
          set the grid from this list
     */
    int[] numbersList =
        Arrays.stream(numbersAsStrings).mapToInt(Integer::parseInt).toArray();
    int k=0;
    for(int i=0;i<numberOfRows;i++){
      for(int j=0;j<numberOfColumns;j++){
        numbers[i][j] = numbersList[k];
        k++;
      }
    }

    /* TODO
          the goal of this method is to get the numbers entered into the [][] numbers format
     */
  }

  public void markNumber(int number) {
    boolean found = false;
    for(int i=0;i< numbers.length;i++){
      for(int j=0; j<numbers[i].length;j++ ){
        if(numbers[i][j]==number){
          markedOff[i][j]=true;
          found = true;
          System.out.printf("Marked off %d\n",number);
        }
      }
    }
    if (!found){
      System.out.printf("Number %d not on this card\n",number);
    }
    /* TODO
          make use of the [][] markedOff to mark off numbers from [][] numbers as they match
          if not matching an appropriate message must be printed, verify against expected output files
     */

  }

  public boolean isWinner() {
    for(int i=0;  i< markedOff.length;i++){
      for(int j=0; j< markedOff[i].length;j++){
        if(!markedOff[i][j]){
          return false;
        }
      }
    }
    return true;
    /* TODO
          check if there is a winner or not
          all elements of [][] markedOff should be marked off to have a winner (full house)
     */
    //change return statement accordingly (either true or false)
  }
}