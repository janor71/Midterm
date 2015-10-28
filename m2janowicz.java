// MIDTERM M2 10/28/15

// MY FIRST NAME IS ------ Rebeca
// MY LAST NAME  IS --------Janowicz
// MY THIRD NAME IS--------Vicky           I don't have a middle so I am gonna pick a random name

// THREE WORDS

//  first word............root
//  second word...........jam
//  third word............voice

String title=  "CST112 MIDTERM EXAM" ;
String news=   "Click any ball to reset it to middle half of table.  (r resets all.)";
String author=  "Rebeca Janowicz";
String title1 =  " SCORE";

// GLOBALS FOR THE BALLS 
float rootX, rootY,  rootDX, rootDY;
float jamX,  jamY,  jamDX,  jamDY; 
float voiceX,  voiceY,  voiceDX,  voiceDY; 

//GLOBALS FOR TABLE 
float oregon = 50, maine= 400 , dakota= 150, texas = 650;                           // TABLE PERIMETER 
float midwest= 350;
boolean wall = true;
boolean going = false;
int pooltableR=23, pooltableG=85, pooltableB= 18;     // GREEN POOL TABLE 

int score;
int count = 0;

// GLOBALS FOR BUTTONS 
float buttonX=0;
float buttonY=0;
float buttonW= 100;
float buttonH= 50;

float buttonX2=0;
float buttonY2=110;
float buttonW2= 120;
float buttonH2= 60;
float ratX=0;
float ratY = 480;
float ratDX = 1;

// SETUP
void setup(){
  //640,480
  size(700,500); 
  
     oregon= 50;                        
     maine = 400;                       
     dakota =150;                       
     texas = 650; 
     midwest= 350;
    // x= width;
    // y= 480;
 reset();
}
void reset() {
  if (wall = true) {
//LOCATION OF BALLS
     rootX =  random(midwest, texas);        rootY= random(maine,dakota);
     jamX =   random(midwest, texas);        jamY = random(maine,dakota);
     voiceX = random(midwest, texas);        voiceY =random(maine,dakota);
  
// SPEED OF BALLS
     rootDX =  random(-2,3);        rootDY= random(-2,3);
     jamDX =   random(-2,3);        jamDY = random(-2,3);
     voiceDX = random(-2,3);        voiceDY=random(-2,3);
    
     
    pooltableR=23;
    pooltableG=85;
    pooltableB= 18;
    score=0;
  }
}
void draw() {
      poolTable(oregon, maine, texas,dakota);
      bounce();
      balls();
      collisions();
      message();
      buttons();
      rat();
      count= count +1;
 
  if (going) { 
    
  ratX = ratX + 1; }
}

// SHOWING POOL TABLE      

void poolTable(float oregon, float maine, float texas, float dakota)  {
      background(245,171,111);
      rectMode(CORNERS);
      fill(pooltableR, pooltableG, pooltableB);
      strokeWeight(20);
      stroke(108,45,49);
      rect(oregon,maine,texas, dakota); 
      fill(255);
      strokeWeight(20);
      
   if (wall== true){
      float midwest= (oregon+texas)/2;
      strokeWeight(20);
      stroke(108,45,49);
      line(midwest, maine, midwest, dakota);
   }
  }  
 
  
// SHOW BALLS 
  void balls() {
      noStroke();
      fill(252,231,66);                      // YELLOW root
      ellipse( rootX,rootY,30,30);
      fill(27,31,170 );                      // BLUE root
      ellipse( jamX,jamY, 30,30 );
      fill(240,52,19);                       // RED root
      ellipse( voiceX,voiceY, 30,30 ); 
    
// BALLS NUMBERED      
      fill(0); 
      textSize(10);
      text('1', rootX, rootY);               
      text('2', jamX,jamY);
      text('3', voiceX,voiceY);
  }

//BALLS BOUNCE OF POOL TABLE  
  void bounce() {
    
  if (wall == true) { 
      rootX += rootDX; if ( rootX < midwest + 20|| rootX > texas)    rootDX *= -1;
      rootY += rootDY; if ( rootY > maine  || rootY < dakota )       rootDY *=  -1; 
      
      
      jamX += jamDX;   if ( jamX < midwest +20 || jamX > texas )    jamDX *= -1; 
      jamY += jamDY;   if ( jamY > maine|| jamY < dakota)           jamDY *=  -1;
       
      voiceX += voiceDX;  if ( voiceX < midwest +20|| voiceX  > texas)    voiceDX *= -1;  
      voiceY += voiceDY;  if ( voiceY > maine|| voiceY < dakota)          voiceDY *=  -1;  
  }
      rootX += rootDX; if ( rootX < oregon|| rootX > texas)    rootDX *= -1;
      rootY += rootDY; if ( rootY > maine  || rootY < dakota )       rootDY *=  -1; 
      
      
      jamX += jamDX;   if ( jamX < oregon || jamX > texas )    jamDX *= -1; 
      jamY += jamDY;   if ( jamY > maine|| jamY < dakota)           jamDY *=  -1;
       
      voiceX += voiceDX;  if ( voiceX < oregon|| voiceX  > texas)    voiceDX *= -1;  
      voiceY += voiceDY;  if ( voiceY > maine|| voiceY < dakota)          voiceDY *=  -1;  
     
}
// COLLISIONS 
void collisions() {
      float tmp;
      
        if ( dist( rootX,rootY, jamX,jamY ) < 30 ) {
          tmp=jamDX;  jamDX=rootDX;  rootDX=tmp;
          tmp=jamDY;  jamDY=rootDY;  rootDY=tmp;
          score = score +1;
        }
          
          if ( dist( jamX,jamY, voiceX,voiceY ) < 30 ) {
          tmp=voiceDX;  voiceDX=jamDX;  jamDX=tmp;
          tmp=voiceDY;  voiceDY= jamDY;  jamDY=tmp;
          score = score + 1;
        }
           if ( dist( rootX,rootY, voiceX,voiceY ) < 30 ) {
          tmp=voiceDX;  voiceDX=rootDX;   rootDX=tmp;
          tmp=voiceDY;  voiceDY= rootDY;  rootDY=tmp;
          score = score + 1;
         }
  }
  
  // MESSAGES 
    void message() {
      fill(0);
      stroke(0);
      textSize(15);
      text( title, 200, 20 );
      text( news, 200, 40);
      text( author,10,470);
      textSize(20);
      text(score,width/2,height-50);
      text(title1,width/2-90,height-50);
  }
  
  // BUTTONS CONTROL CODE
  void buttons() {
  noStroke();
  fill(108,45,49);
  rect(buttonX, buttonY, buttonW, buttonH);
  fill(255);
  text("RESET", buttonX+20, buttonY+35);
  // REMOVE WALL    
  noStroke();
  fill(108,45,49);
  rect(buttonX2, buttonY2, buttonW2, buttonH2);
  fill(255);
  text("remove wall", buttonX2, buttonY2-10);
  }
// RAT   
 void rat() {
   
   
  strokeWeight(1);
  stroke(0);
  fill( 185,130,56);                         // body's color 
  ellipse(ratX,ratY, 60,30 );                // rat's body
  fill(95,62,21);                            // tail color
  ellipse(ratX-30,ratY-5,5,15);              // tail
  fill( 185,130,56,185);                     // head color
  ellipse(ratX+30,ratY-10,20,30);            // head
  fill(95,62,21);                            // ear color
  triangle( ratX+26,height-45, ratX+34,height-45, ratX+30,height-51);
  fill(0);                                   // eye color
  ellipse(ratX+28,ratY-13,5,3);              // eye
  fill(0);                                   // nose color
  ellipse(ratX+40,ratY-10,5,5);              // nose
  fill(247,195,226);                         // mouth's color
//

// LEGS
  float leg1=ratX+10, leg2=ratX-15;
   strokeWeight(5);
   stroke(95,62,21); 
   if (count/30 % 2 == 0) {
      line(leg1,ratY+5, leg1-5,ratY+20);
      line(leg2,ratY+5, leg2-5,ratY+20);
   } else{
      line(leg1,ratY+5, leg1+5,ratY+20);
      line(leg2,ratY+5, leg2+10,ratY+20);
   }
   strokeWeight(1);
 }
 
  void mousePressed() {
   
   if ((mouseX < buttonX + buttonW &&
        mouseX > buttonX)&&
       (mouseY < buttonY + buttonH &&
        mouseY > buttonY )) {
        reset();
        
     } else if 
  // RESTORES THE WALL      ( although is not working). 
        ((mouseX < buttonX2 + buttonW2 && 
          mouseX > buttonX2) &&
         (mouseY < buttonY2 + buttonH2 && 
          mouseY > buttonY2)){
            wall = false; 
            
      // RESET THE BALLS RANDOMLY      
      } else if 
          (mouseX >= rootX &&
           mouseY >= rootY) 
          {rootX= random(midwest, texas);   rootY= random(maine, dakota);   
         
      } else if 
          (mouseX >= jamX &&
           mouseY >= jamY) 
         {jamX= random(midwest, texas);   jamY= random(maine, dakota); 
         
      } else if 
          (mouseX >= voiceX &&
           mouseY >= voiceY) 
         { voiceX= random(midwest, texas);   voiceY= random(maine, dakota); }
       
         
  }
    

  void keyPressed() {

    
        if (key == 'r') reset();
        if (key == 'w') { wall=false; }
        if (key == 'q') { exit();  }
        if (key == 'p') { pooltableR=252;  pooltableG=176; pooltableB= 235; }
        if ( key =='m' ){ going = true ; 
    } else {
        going = false;
      }
  
       if (key == '1') {  rootX= random(midwest, texas);   rootY= random(maine, dakota);   } 
     
       if (key == '2') {  jamX= random(midwest, texas);    jamY= random(maine, dakota);    } 
       
       if (key == '3') {  voiceX= random(midwest, texas);  voiceY= random(maine, dakota);  }
       
       // THIS IS EXTRA. IT WILL RESET THE BALLS RANDOMLY IF WALL IS REMOVE. 
     
   if (wall ==false) {
     
       if (key == '1') { rootX= random(oregon, texas);   rootY= random(maine, dakota);     } 
   
       if (key == '2') { jamX= random(oregon, texas);    jamY= random(maine, dakota);      } 
    
       if (key == '3') { voiceX= random(oregon, texas);  voiceY= random(maine, dakota);    }
    }

   }
