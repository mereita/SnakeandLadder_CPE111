package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


class Main implements ActionListener
{  
    
 JFrame f;
 JTabbedPane tabPane;
 JPanel mainPanel,howToPanel,gamePanel,playerPassPanel,dicePanel;;
 JPanel gameCenter,gameEast,gameWest,gameNorth,gameSouth;
 Icon p1,p2,header;
 Icon diceIcon;
 
 Icon icon[][]      = new Icon[10][10];
 Icon winnericon[][] = new Icon[10][10];
 
 JButton introB[] = new JButton[5];
 JButton b[][]    = new JButton[10][10];
 JButton start,restart;
 JButton JBplayer,JBcomputer;
 JLabel dice;
 Random randomNo;


 int imageFlag;
 int i,j,num;
 int prevIp1,prevJp1;
 int path;
 int p1value,p2value;
 int player,computer;
 int gameover;
 int cimageFlag = 0;
 int cnoFlag    = 0;
 String str;


  int n[][] = {	
              { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
	      {10,11,12,13,14,15,16,17,18,19},
	      {20,21,22,23,24,25,26,27,28,29},
	      {30,31,32,33,34,35,36,37,38,39},
	      {40,41,42,43,44,45,46,47,48,49},
	      {50,51,52,53,54,55,56,57,58,59},
	      {60,61,62,63,64,65,66,67,68,69},
	      {70,71,72,73,74,75,76,77,78,79},
	      {80,81,82,83,84,85,86,87,88,89},
	      {90,91,92,93,94,95,96,97,98,99},
	      };

 int game[][] = {
	        {100,99,98,97,96,95,94,93,92,91},
	        {81,82,83,84,85,86,87,88,89,90},
		{80,79,78,77,76,75,74,73,72,71},
		{61,62,63,64,65,66,67,68,69,70},
		{60,59,58,57,56,55,54,53,52,51},
		{41,42,43,44,45,46,47,48,49,50},
		{40,39,38,37,36,35,34,33,32,31},
		{21,22,23,24,25,26,27,28,29,30},
		{20,19,18,17,16,15,14,13,12,11},
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9,10},
	        };
	

 int winner[][] = {
		 { 1, 2, 3, 4, 5, 6, 7, 8, 9,10},
		 {11,12,13,14,15,16,17,18,19,20},
		 {21,22,23,24,25,26,27,28,29,30},
		 {31,32,33,34,35,36,37,38,39,40},
		 {41,42,43,44,45,46,47,48,49,50},
		 {51,52,53,54,55,56,57,58,59,60},
		 {61,62,63,64,65,66,67,68,69,70},
		 {71,72,73,74,75,76,77,78,79,80},
		 {81,82,83,84,85,86,87,88,89,90},
		 {91,92,93,94,95,96,97,98,99,100},
	         };

 Main() {

 //creat and set layout of a new frame
 f = new JFrame(".");
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 f.setLayout(new BorderLayout());
 //creat panel and tab
 mainPanel = new JPanel();
 tabPane = new JTabbedPane(JTabbedPane.LEFT);

 
 for(int i = 0;i<introB.length;i++)
 	{
	 introB[i] = new JButton(Integer.toString(i));
	}

   randomNo = new Random();
   dice = new JLabel();
   
   // create and set style for button of Player 1
   JBplayer   = new JButton("PLAYER 1");
   JBplayer.setEnabled(false);
   JBplayer.addActionListener(this);
   JBplayer.setFont(new Font("Letter Gothic Std", Font.BOLD, 18));
   JBplayer.setBackground(Color.WHITE);
   JBplayer.setForeground(Color.BLACK);
   
   // create and set style for button of Player 2
   JBcomputer = new JButton("PLAYER 2"); 
   JBcomputer.setEnabled(false);
   JBcomputer.addActionListener(this); 
   JBcomputer.setFont(new Font("Letter Gothic Std", Font.BOLD, 18));
   JBcomputer.setBackground(Color.WHITE);
   JBcomputer.setForeground(Color.BLACK);
   
   // call method HowtoPlay and Game to creat a panel
   howToPlay();
   game();
   
   f.add(tabPane,BorderLayout.CENTER);
   f.setResizable(false);
   f.setSize(750,700);
   f.setVisible(true);
  
}


void howToPlay() {
    
 // add tab for how to play
 howToPanel = new JPanel();
 JPanel main = new JPanel();
 JLabel l1   = new JLabel();
 Icon mypic; 
 //import a image of how to play panel from folder
 mypic = new ImageIcon("images/howToPlay.jpg");      
 l1.setIcon(mypic);
 
 // set howToPlay panel layout
 howToPanel.setLayout(new BorderLayout());  
 howToPanel.add(l1,BorderLayout.CENTER); 
 
 //add and set a style of tab name "HOW TO PLAY"
 tabPane.addTab("HOW TO PLAY",howToPanel);
 tabPane.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
 tabPane.setBackground(Color.WHITE);
 tabPane.setForeground(Color.BLACK);  
}


void game() { 
    
  // add tab for game panel 
 JLabel gameheader = new JLabel();
 JLabel logo = new JLabel(); 
 JLabel l1   = new JLabel(); 
 JLabel l2   = new JLabel(); 
 
 // add and name restart button
 restart = new JButton("RESTART");
 restart.setEnabled(false);
 restart.addActionListener(this);
 
 // change style of  button
 restart.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
 restart.setBackground(Color.WHITE);
 restart.setForeground(Color.BLACK);

 // add and name start button
 start = new JButton("START"); 
 start.addActionListener(this);
 
 // change style of  button
 start.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
 start.setBackground(Color.WHITE);
 start.setForeground(Color.BLACK);
 
 // add and set style of game panel
 gamePanel = new JPanel();
 gamePanel.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
 gamePanel.setBackground(Color.WHITE);
 gamePanel.setForeground(Color.BLACK);
 
 
 gameCenter = new JPanel();
 gameWest   = new JPanel();
 gameNorth  = new JPanel();
 gameSouth  = new JPanel();
 
 gameCenter.setLayout(new GridLayout(10,10));
 gameEast  = new JPanel(new GridLayout(2,1));
 gameWest.setLayout(new FlowLayout());
 gameNorth = new JPanel(new FlowLayout());
 gameSouth = new JPanel(new FlowLayout());

 gamePanel.setLayout(new BorderLayout());
 
 //input image of player  1 and player 2
 p1 = new ImageIcon("images/p1.gif");        
 p2 = new ImageIcon("images/p2.gif");       
 l1.setIcon(p1);
 l2.setIcon(p2);
 
 //input image of header
 header = new ImageIcon("images/header.jpg");        
 gameheader.setIcon(header);
 
 // loop to input image from folder  1 to 100 
  for(int i = 0;i<10;i++)
	for(int j = 0;j<10;j++)
	{
			b[i][j] = new JButton();        
			       path = game[i][j];
			        str = Integer.toString(path);
			icon[i][j] = new ImageIcon("images/board/"+str+".jpg");
	                b[i][j].setIcon(icon[i][j]);
                 
	}
// loop to input image from folder when player win 
for(int i = 0;i<10;i++)
	for(int j = 0;j<10;j++)
	{
			path = winner[i][j];
			str  = Integer.toString(path);
			winnericon[i][j] = new ImageIcon("images/winner/"+str+".jpg");
              
	}
// input image of a dice
         str = Integer.toString(1);
         diceIcon = new ImageIcon("images/dice/"+str+".jpg");
         dice.setIcon(diceIcon);
 
	 
 // add Player 1 and 2 button at the South of the panel 
 gameSouth.add(l1); 
 gameSouth.add(JBplayer);
 gameSouth.add(dice);
 gameSouth.add(JBcomputer); 
 gameSouth.add(l2); 
 
// add Start , Restart and header at the North of the panel
 gameNorth.add(start);
 gameNorth.add(gameheader);
 gameNorth.add(restart);
  
 
  for(int i = 0;i<10;i++)
	{
	   for(int j = 0;j<10;j++)
	     {
		gameCenter.add(b[i][j]);
       
	     }
	}


 gamePanel.add(gameCenter,BorderLayout.CENTER);
 gamePanel.add(gameWest,BorderLayout.WEST);
 gamePanel.add(gameNorth,BorderLayout.NORTH);
 gamePanel.add(gameSouth,BorderLayout.SOUTH);
 tabPane.addTab("GAME",gamePanel);
  
}


void chance() {
    
 int n = randomNo.nextInt(3);
 int i = 0;

   if(n == 0)
      chance();
 
   if(n == 1)
      {
      player   = 1;	
      computer = 0;
      }
   else if(n == 2)
      {
      player   = 0;
      computer = 1;
      }
   if(n == 1)
      {
      JBcomputer.setEnabled(false);
      JBplayer.setEnabled(true);
      }
   else if(n == 2)
      {
      JBcomputer.setEnabled(true);
      JBplayer.setEnabled(false);
      }

}


 public void actionPerformed(ActionEvent e) {
 // when p1 roll a dice move the player image
    int n = 0;
        try{
          if(e.getSource() == JBplayer)
	   {
   
         do{
	  n = playerPassNumber();
	   }
         
         while(n == 0);
	       
		p1value = p1value+n;
		 if(p1value >= 100)
		  {
		    p1value = 100;
		  }
		 
		    playerimageTraval(p1value);		
		
		    JBcomputer.setEnabled(true);
		    JBplayer.setEnabled(false);
		    setBothImage();
 	    }
     // when p2 roll a dice move the player image     
          else if(e.getSource() == JBcomputer)
	    {
	       do{
		   n = playerPassNumber();
		 }
               while(n == 0);
		
		   p2value = p2value+n;
		   if(p2value >= 100)
		{
		 p2value=100;
		}
		computerimageTraval(p2value);
		JBcomputer.setEnabled(false);
		JBplayer.setEnabled(true);
	
		setBothImage();	
	    }
          // if restart button was pressed
           else if(e.getSource() == restart)
	    {
  	         p1value    = 0;
	         p2value    = 0;
	         cnoFlag    = 0;
	         cimageFlag = 0;

	         chance();
	         rePrint();
	    }
           //if the button start was pressed
           else if(e.getSource() == start)
	    {
		gameover   = 0;
		p1value    = 0;
		p2value    = 0;
		cnoFlag    = 0;
	        cimageFlag = 0;
		rePrint();
	        start.setEnabled(false);
	        restart.setEnabled(true);
	        chance();
	    }
	    else
	    {
	        imageChange(e);	
	    }
          
            }catch(Exception ee)
            { }
}

// random number and a dice image
int playerPassNumber() {
    
   int i = randomNo.nextInt(7);
   
   	str = Integer.toString(i);
	 diceIcon = new ImageIcon("images/dice/"+str+".jpg");
	 dice.setIcon(diceIcon);
         
   return i;
 
}

// when player reach finish point 
void winnerdraw() {
    
            int i = 0;
            // set the button and clear player
		 start.setEnabled(true);
		 restart.setEnabled(false);
		 JBplayer.setEnabled(false);
		 JBcomputer.setEnabled(true);
		 JBcomputer.setEnabled(false);
	    // then input winner image from folder	 
    for(int k = 0;k<10;k++)
	for(int l = 0;l<10;l++)
	{
		gameover = 1;
         b[k][l].setIcon(winnericon[k][l]);  
         
	}
		     
}


void rePrint() {
    
   try{

      for( i = 0; i<10 ; i++)
	  {
	    for(j = 0 ; j<10 ; j++)
	  {
		 b[i][j].setIcon(icon[i][j]);
	  }
	}
	
   }catch(Exception e)
	{
	}

}


void playerimageTraval(int n) {
    
  int i = j = 0;
  int imageFlag = 0;
  int noFlag = 0;

      if(gameover == 0)
        {
          try{
	      rePrint();	
	        for(i = 0; i<10 ; i++)
	          {
		    for(j = 0; j<10 ; j++)
		      {
			if(n == game[i][j])
			  {
                            noFlag = 1;
		            break;
			  }
		      }
 		        if(noFlag == 1)
			break;
	          }
                    if(noFlag == 1)
		  {
		    if(imageFlag == 0)
		  {
		    Thread.sleep(200);
		       b[i][j].setIcon(p1);
		       imageFlag = 1;
		       prevIp1 = i;
		       prevJp1 = j;
	          }
            else
	     {
	 	path = game[prevIp1][prevJp1];
		str = Integer.toString(path);
 		Thread.sleep(200);
		icon[prevIp1][prevJp1] = new ImageIcon("images/"+str+".jpg");
		Thread.sleep(200);
	        b[prevIp1][prevJp1].setIcon(icon[prevIp1][prevJp1]);
		b[i][j].setIcon(p1);
		prevIp1 = i;
		prevJp1 = j;
	        }

/*************************** checks for stairs ***************************/
                    
		if(n == 4)
			{
			n = 14;
			playerimageTraval(n);
			p1value = n;
			}
		else if(n == 9)
			{
			n = 31;
			playerimageTraval(n);
			p1value = n;
			}
		else if(n == 20)
			{
			n = 38;
			playerimageTraval(n);
			p1value = n;
			}
		else if(n == 28)
			{
			n = 84;
			playerimageTraval(n);
			p1value = n;
			}
		else if(n == 40)
			{
			n = 59;
			playerimageTraval(n);
			p1value = n;
			}
                else if(n == 51)
			{
			n = 67;
			playerimageTraval(n);
			p1value = n;
			}
                else if(n == 63)
			{
			n = 81;
			playerimageTraval(n);
			p1value = n;
			}


 /*************************** Checks for Snakes ***************************/
		if(n == 99)
			{
		         n = 78;
			 playerimageTraval(n);
			 p1value = n;			
			}
		else if(n == 95)
			{
		         n = 75;
			 playerimageTraval(n);
			 p1value = n;			
			}
		else if(n == 89)
			{
		         n = 26;
			 playerimageTraval(n);
			 p1value=n;			
			}
		else if(n == 64)
			{
		         n = 60;
			 playerimageTraval(n);
			 p1value = n;			
			}
		else if(n == 17)
			{
		         n = 7;
			 playerimageTraval(n);
			 p1value = n;			
			}

		}	
		
	if(n >= 100)
	{   
		winnerdraw();	
	}
        
            }
        catch(Exception e)
           {
           }
        }

}

void setBothImage() {
        
    int i  = 0;
    int j = 0;
    int noFlag = 0;

        if(gameover == 0)
           {
             for(i = 0; i<10 ; i++)
	       {
		 for(j = 0; j<10 ; j++)
			{
			 if(p1value == game[i][j])
			    {
                                noFlag = 1;
				break;
			    }
			}
 		if(noFlag == 1)
			break;
	       }

                if(noFlag == 1)
                  {
                    b[i][j].setIcon(p1);  
                  }
                    noFlag = 0;

             for(i = 0; i<10 ; i++)
	       {
		 for(j = 0; j<10 ; j++)
			{
			 if(p2value == game[i][j])
			    {
                                noFlag = 1;
				break;
			    }
			}
 		if(noFlag == 1)
			break;
	       }

                if(noFlag == 1)
                 {
                   b[i][j].setIcon(p2);
                 }
           }
}


void computerimageTraval(int n) {
    
        int i = j = 0;
        int imageFlag = 0;
        int noFlag = 0;

    try{
	rePrint();	
	  for(i = 0; i<10 ; i++)
      {
		 for(j = 0; j<10 ; j++)
			{
			 if(n == game[i][j])
			    {
                                noFlag = 1;
				break;
			    }
			}
 		         if(noFlag == 1)
			     break;
      }

	              if(noFlag == 1)
		    {
		if(imageFlag == 0)
		{
		 Thread.sleep(200);
		 b[i][j].setIcon(p2);
		 imageFlag = 1;
		 prevIp1 = i;
		 prevJp1 = j;
	        }
        else
		{
	 	path = game[prevIp1][prevJp1];
		str = Integer.toString(path);
 		Thread.sleep(200);
		icon[prevIp1][prevJp1] = new ImageIcon("images/"+str+".jpg");
		Thread.sleep(200);
	        b[prevIp1][prevJp1].setIcon(icon[prevIp1][prevJp1]);
		b[i][j].setIcon(p1);
		prevIp1 = i;
		prevJp1 = j;
	        }
           

/*************************** checks for stairs ***************************/

		if(n == 4)
			{
			n = 14;
			computerimageTraval(n);
			p2value = n;
			}
		else if(n == 9)
			{
			n = 31;
			computerimageTraval(n);
			p2value = n;
			}
		else if(n == 20)
			{
			n = 38;
			computerimageTraval(n);
			p2value = n;
			}
		else if(n == 28)
			{
			n = 84;
			computerimageTraval(n);
			p2value = n;
			}
		else if(n == 40)
			{
			n = 89;
			computerimageTraval(n);
			p2value = n;
			}
                else if(n == 51)
			{
			n = 67;
			computerimageTraval(n);
			p2value = n;
			}
                else if(n == 63)
			{
			n = 81;
			computerimageTraval(n);
			p2value = n;
			}


/*************************** Checks for Snakes ***************************/
		if(n == 99)
			{
		         n = 78;
			 computerimageTraval(n);
			 p2value = n;			
			}
		else if(n == 95)
			{
		         n = 75;
			 computerimageTraval(n);
			 p2value = n;			
			}
		else if(n == 89)
			{
		         n = 26;
			 computerimageTraval(n);
			 p2value = n;			
			}
		else if(n == 64)
			{
		         n = 60;
			 computerimageTraval(n);
			 p2value = n;			
			}
		else if(n == 17)
			{
		         n = 7;
			 computerimageTraval(n);
			 p2value = n;			
			}

		}	
		

	if(n >= 100)
	{   
		gameover = 1;	
		winnerdraw();
	}
		
}
catch(Exception e)
{
 
}

}


void imageChange(ActionEvent e) {
     
   int i = j = 0;
   int flag = 0;

try{
 for( i = 0; i<10 ; i++)
    {
	for( j = 0; j<10 ; j++)
	{
	 if(e.getSource() == b[i][j])
		{
		    flag = 1;
		    break;
		}
	 }

	 if(flag == 1)
		break;
     }


	if(imageFlag == 0)
	{ 
		Thread.sleep(200);
		b[i][j].setIcon(p1);
		imageFlag = 1;
		prevIp1 = i;
		prevJp1 = j;
		}
            else
	        {
		path = game[prevIp1][prevJp1];
		str = Integer.toString(path);
		Thread.sleep(200);
		icon[prevIp1][prevJp1] = new ImageIcon("images/"+str+".jpg");
			 Thread.sleep(200);
	        b[prevIp1][prevJp1].setIcon(icon[prevIp1][prevJp1]);
		b[i][j].setIcon(p1);
		prevIp1 = i;
		prevJp1 = j; 
      }
    }
catch(Exception ee)
	{
		ee.printStackTrace();
	}
}


public static void main(String args[])
{
 Main m = new Main();
}

}