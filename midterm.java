//// Midterm code for 59CST112

/**************************************************************
BE SURE TO CHANGE THE NEXT SEVERAL LINES, USING YOUR REAL NAME.

    MY FIRST NAME IS......William
    MY MIDDLE NAME IS.....Henry
    MY LAST NAME IS.......Harrison
    
PICK 3 WORDS THAT START WITH YOUR INITIALS, using lower case letters:

    first word............wolf
    second word...........hamburger
    third word............hippopotamus
    
USE THESE 3 WORDS TO NAME ALL VARIABLES FOR 3 POOL BALLS.
(You may abbreviate any words, but start with same letter.)
***************************************************************/


//// GLOBALS FOR 3 colored balls ////
//// (Assume ball diameter is 30.) ////
float wolfX,  wolfY,  wolfDX,  wolfDY;          //++++ MODIFY THIS.  Don' use "wolf". ++++
float hamX,  hamY,  hamDX,  hamDY;              //++++ MODIFY THIS.  Don' use "ham". ++++
float hippoX,  hippoY,  hippoDX,  hippoDY;      //++++ MODIFY THIS.  Don' use "hippo". ++++
            //++++ MODIFY THESE DECLARATIONS -- Do not use "wolf" or "ham" or "hippo" ++++


//// OTHER GLOBALS:  strings, pool table, etc ////

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Your Name";

float left=50, right=450, top=100, bottom=250;        // Table boundaries
float middle=250;
boolean wall=true;

int tableRed=150, tableGreen=250, tableBlue=150;      // green pool table
int score=0,m=0,k=0;

    // ADD YOUR OWN DECLARATIONS HERE. ++++


//// SETUP:  size and table
void setup() {
    size( 500, 303 );          //++++ CHANGE THE SIZE -- see instructions! ++++
  
    //// MODIFY THIS CODE TO MAKE TABLE CENTERED IN WINDOW.  ++++

    // Table boundaries
    left=50;
    right=450;
    top=100;
    bottom=250;
    middle=250;
 }


//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  buttons();
  bounce();
  collisions();
  show();
  messages();
}


//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'q') { exit();  }
    //++++ ADD YOUR OWN CODE HERE. ++++
}


//// SCENE:  draw the table with wall down the middle
void table( float east, float north, float west, float south ) {
  fill( tableRed, tableGreen, tableBlue );    // pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( east-20, north-20, west+20, south+20 );

            //++++ MODIFY THIS CODE, as necessary. ++++

  // Start with a WALL down the middle of the table! 
  if (wall) {
    float middle=  (east+west)/2;    
    stroke( 0, 127, 0 );
    line( middle,north+10, middle,south-10 );
  }
  stroke(0);
  strokeWeight(1);
}

//// ACTION:  bounce off walls, collisions
void bounce() {
    //// ADD YOUR OWN CODE HERE. ++++
}
void collisions() {
    //// ADD YOUR OWN CODE HERE. ++++
}


//// SHOW:  balls, messages, etc.
void show() {
    //++++ ADD YOUR OWN CODE HERE. ++++
}
void buttons() {
    //++++ ADD YOUR OWN CODE HERE. ++++
}
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );

  // Also, display the number of collisions.

    //++++ ADD YOUR OWN CODE HERE. ++++

    
  /* REMOVE THIS LINE */        blink();      /* STUDENT SHOULD REMOVE THIS LINE!!! */

}





















//+++++++++++++++++  ALL CODE BELOW THIS LINE SHOULD BE REMOVED ++++++++++++++++++++++//


int mx=0;

//// BLINK the instructions for Midterm. ////
void blink() {
 
  fill(255,0,0);
  text( "Hold the '!' key for MIDTERM instructions", width-250, height-5 );
  
  if (key == '?') { help(); return; }
  if (key == '!') { help(); return; }
  if (keyPressed && key == 'w') { wall=!wall; }
  if (keyPressed) {
    tableRed= key == 'p' ? 250 : 150;
    tableGreen= key == 'p' ? 150 : 250;
  }
  //--  text( key+"", 10,20 );
  //--  text( tableRed, 10,30 );
  //--  text( tableGreen, 10,40 );
  //
  

  //// Mouse code ////
  if (keyPressed && key == 'm') { 
    mx += 5;
    if (mx>width+100) mx=0;    
    rat( mx );
  }else {
      text( "m key for mouse", 70, height-25 );
      text( "p key for pink table", width*2/3, height-25 );
  }


  k++;
  if (k>900 && key == '0') { k=0; }
  int n=k/180;
  if (k<9000) { 
    if (k%15 == 0)    ran(); 
  }
  if (k%180 == 0) {
         // Random positions, score, etc.
         if (k>900) {
           wall = !wall;
           background(0);
         }
         ran();
         score=  int( random( 100*n, 200*n )  );          
  }

  fill(255);
  if (wall) text( "W\n\nA\n\nL\n\nL\n\n", middle-3,top+30 );

  demo();
}
void demo() {
  //// Display text in "demo" mode.  ++++  Student should remove all of this code!
  if (k%180 > 90) {
    /* REMOVE THIS LINE */        text(score +  " collisons", 400,20 );
    //
    float bY=40;
    float b0X=10, b1X=110, b2X=210, b3X=310, b4X=410;
    /* REMOVE THIS LINE */        fill(255);  rect(b0X,bY, b0X+80,bY+28); fill(255,0,0);
    /* REMOVE THIS LINE */        fill(255,255,0);  rect(b1X,bY, b1X+80,bY+28); fill(255,0,0);
    /* REMOVE THIS LINE */        text( "Reset all balls\n (right half)", b0X+2,bY+10 );
    /* REMOVE THIS LINE */        text( "button #1:\nRemove wall.", b1X+2,bY+10 );
    /* REMOVE THIS LINE */        text( "button #2:\nPink table ('p').", b2X+2,bY+10 );
    /* REMOVE THIS LINE */        text( "button #3:\nAnimated mouse ('m').", b3X+2,bY+10 );
  }else{
    /* REMOVE THIS LINE */        fill(255,0,0);   b( 1, "wolf ball", wolfX,  wolfY );
    /* REMOVE THIS LINE */        fill(150,150,0); b( 2, "ham ball", hamX,  hamY );
    /* REMOVE THIS LINE */        fill(0,100,255);   b( 3, "hippo ball", hippoX,  hippoY );  
    fill(255,0,255);
    if (!wall) text( "NO WALL. \n   Balls can move \n             to left side!!", 60, 100 );
    else       text( "The WALL makes balls remain \n  on the RIGHT side only!", 60, 220 );
  }
}
void leg( float x, float y, float toe ) {
      line( x,y, x+toe,y+10 );
}
void rat( float mx ) {
    
    fill(255);
    triangle( mx+80,height-40, mx+88,height-40, mx+83,height-56 );
    triangle( mx+86,height-40, mx+94,height-40, mx+90,height-56 );
    noStroke();
    ellipse( mx+70,height-30, 40,18 );
    ellipse( mx+90,height-40, 20,10 );

    strokeWeight(3);
    stroke(0);
    line( mx+55,height-35, mx+45,height-50 );    // Tail.

    fill(0);    
    ellipse( mx+85,height-45, 2,2 );              // eyes & nose
    ellipse( mx+90,height-45, 2,2 );
    ellipse( mx+99,height-40, 3,3 );
    // LEGS....
    float toe=5;
    if (k/15 % 2 > 0) toe=  -5;
    leg( mx+56,height-22, toe);                    // animated legs!
    leg( mx+64,height-22, toe);
    leg( mx+80,height-22, toe);
    leg( mx+88,height-22, toe);
    strokeWeight(1);
}  
void ran() {
  if (wall) {
         wolfX=  random( 280,right-20 );   wolfY=  random( top,bottom );
         hamX=  random( 280,right-20 );       hamY=  random( top,bottom );
         hippoX=  random( 280,right-20 );     hippoY=  random( top,bottom );         
  }else{
         wolfX=  random( left+50,right-20 );   wolfY=  random( top,bottom );
         hamX=  random( left+50,right-20 );       hamY=  random( top,bottom );
         hippoX=  random( left+50,right-20 );     hippoY=  random( top,bottom );         
  }
}
void b(int n, String ran, float y, float x){ellipse(y,x,30,30);text(ran,y-30,x-20); fill(0);text(n,y-5,x);}
void say(String s){  text(s,10,12*m++); }



void help() { background( 150,220,220 ); m=1;
  say( "                   I N S T R U C T I O N S" );
  say("");
  say( "All specifications for project 2 shall apply to this MIDTERM ''M1''." );
  say( "Display three different-colored balls, each with a number" );
  say( "Move the balls (as in project 2) and handle all (elastic) collisions between them.");
  say( "Good coding standards also apply - especially READABILITY and MODULARIZATION." );
  say("");
  say( "Change size of window to 640 x 480, and make sure table is centered." );
  say( "(Your code must work properly for any reasonable window size.)" );
  say( "Change variable names to three words that start with your initials.");
  say("");
  say( "Add a WALL (in the middle) that makes balls remain on right side of table." );
  say( "Keys 1, 2, and 3 reset one ball to right half of table (random X,Y,DX,DY)." );
  say( "Add BUTTONS to do the following:" );
  say( "   1. Reset all balls to the right side of table.   ['r']" );
  say( "   2. Remove the wall; allow balls to move all over table!  ['w']" );
  say( "   3. Change table color to pink.  ['p']" );
  say( "   4. Animated mouse runs across bottom wall of table, with legs moving.  ['m']" );
  say("");
  say( "M2 TAKEHOME EXAM (and optionally for extra credit on M1):" );
  say( "   5. Change window size to 700x500; table centered; code works properly." );
  say( "   6. Click on any ball to move it to right half of table.   (same as keys 1,2,3.)" );
  say( "M3 IN-CLASS EXAM (next week) will include:" );
  say( "   7. Write a Ball class (that behaves similarly)." );  
  say( "   8. Write a Bird class, that draws an animated bird with flapping wings.  ['b']" );  
}



