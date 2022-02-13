import java.util.*;
import java.util.Random;

public class tictactoe{

public static char[][] borad ={ {' ',' ',' '},
                    {' ',' ',' '},
                    {' ',' ',' '} };

public static void main(String[] args){

  displayGameBorad(borad);

  String userName= GetName();


  Player user = new Player(userName,'X');
  Player cpu = new Player("CPU",'O');

  //user.displayplayer();
  do{

    user.playerturn();
    if ((user.isGameDone()))
      {break;}
    cpu.playerturn();
    if ((cpu.isGameDone()))
      {break;}

    displayGameBorad(borad);


  }
    while (true);
    displayGameBorad(borad);

}

//this method is used to get the users name and returns that name to the main class
public static String GetName(){

  Scanner scanner = new Scanner(System.in);
  System.out.println("Welcome to Tic Tac Toe! \nWhats your name?");
  String userName = scanner.nextLine();
  System.out.println("Hi " +userName);
  return userName;

}
// this method is used to display the GameBorad; By using a forloop to iterate through the 2D array
public static void displayGameBorad(char[][] GameBorad){
  System.out.println("   0 1 2 \n");

  for(int i=0; i<3;i++){

      System.out.print((i)+"  ");
      System.out.println(GameBorad[i][0]+"|"+ GameBorad[i][(1)]+"|"+GameBorad[i][2]);
      if (i <2){
      System.out.println("   -+-+-");}
    }
System.out.println();
}

// this class will create objects for the players of the game
public static class Player{


  char PlayerPiece = 'z';
  String PlayerName = "bob";
  boolean gamestatus =false;

  Player(String name,char piece){
    this.PlayerName = name;
    this.PlayerPiece = piece;

  }

  public void displayplayer(){
    System.out.println(PlayerPiece);
    System.out.println(PlayerName);
  }
// this method uses random class to generate the cpu inputs and check if move is legal
  public int CPUinput(){
    Random rand = new Random();
    int cpumove;
    boolean legal = false;

    do {
      cpumove =rand.nextInt(9)+1;
      legal = isMovelegal(cpumove);
      }
    while(legal== false);
    System.out.println("The CPU move: "+cpumove);

    return cpumove;
  }
  //check to see if we have a winner
  public boolean isGameDone(){

    if ((borad[0][0] == PlayerPiece && borad[0][1] == PlayerPiece &&borad[0][2] == PlayerPiece) ||
        (borad[1][0] == PlayerPiece && borad[1][1] == PlayerPiece &&borad[1][2] == PlayerPiece) ||
        (borad[2][0] == PlayerPiece && borad[2][1] == PlayerPiece &&borad[2][2] == PlayerPiece) ||

        (borad[0][0] == PlayerPiece && borad[1][0] == PlayerPiece &&borad[2][0] == PlayerPiece) ||
        (borad[0][1] == PlayerPiece && borad[1][1] == PlayerPiece &&borad[2][1] == PlayerPiece) ||
        (borad[0][2] == PlayerPiece && borad[1][2] == PlayerPiece &&borad[2][2] == PlayerPiece) ||

        (borad[0][0] == PlayerPiece && borad[1][1] == PlayerPiece &&borad[2][2] == PlayerPiece)||
        (borad[0][2] == PlayerPiece && borad[2][1] == PlayerPiece &&borad[2][0] == PlayerPiece))
    {
      System.out.println("Winner! Winner! Chicken Dinner!\n"+this.PlayerName+" Wins!!");
      return true;
    }
    for (int i =0 ; i<borad.length; i++){
      for(int j = 0; j <borad[i].length; j++)

        {
          if(borad[i][j] == ' ')
          {
            return false;}
        }
    }
    System.out.print("Game is a draw!");
      return true;
  }

  //this method will be used to check if moves are legal


public boolean isMovelegal(int playerInput)

{switch(playerInput){

  case 1:
  return (borad[0][0] == ' ');

  case 2:
  return (borad[0][1] == ' ');

  case 3:
  return (borad[0][2] == ' ');

  case 4:
  return (borad[1][0] == ' ');

  case 5:
  return (borad[1][1] == ' ');

  case 6:
  return (borad[1][2] ==  ' ');

  case 7:
  return (borad[2][0] == ' ');

  case 8:
  return (borad[2][1] == ' ');

  case 9:
  return (borad[2][2] == ' ');

  default:
    return false;

}
}
public int GetUserInput()
{
  int ValidPostion;
  while(true){
    Scanner scanner = new Scanner(System.in);
    System.out.println("where would you like to go? (1-9)");
    ValidPostion = scanner.nextInt();

    if (isMovelegal( ValidPostion))
    {break;
    }
    else
      System.out.println("Invalid move try again");
  }
  return ValidPostion;
}
//this method edits the borad for both cpu and user
public void playerturn(){
  int playerInput;
  //boolean legal = false;

  if (this.PlayerName != "CPU"){
        playerInput = GetUserInput();
    }
  else
    { playerInput = CPUinput();}


  //System.out.println(playerInput);


switch(playerInput){

  case 1:
  borad[0][0] = PlayerPiece;
  break;

  case 2:
  borad[0][1] = PlayerPiece;
  break;

  case 3:
  borad[0][2] = PlayerPiece;
  break;

  case 4:
  borad[1][0] = PlayerPiece;
  break;

  case 5:
  borad[1][1] = PlayerPiece;
  break;

  case 6:
  borad[1][2] =  PlayerPiece;
  break;

  case 7:
  borad[2][0] = PlayerPiece;
  break;

  case 8:
  borad[2][1] = PlayerPiece;
  break;

  case 9:
  borad[2][2] = PlayerPiece;
  break;
  default:
    System.out.println("out of bounce");

}
}
}


}
