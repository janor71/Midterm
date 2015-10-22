// MIDTERM M1 

// MY FIRST NAME IS ------ Rebeca
// MY LAST NAME IS --------Janowicz
// MY THIRD NAME IS--------Vicky           I don't have a middle name so I am gonna pick a random name

// THREE WORDS

//  first word............root
//    second word.........jam
//   third word...........voice


// GLOBALS
float rootX, rootY,  rootDX, rootDY;
float jamX,  jamY,  jamDX,  jamDY; 
float voiceX,  voiceY,  voiceDX,  voiceDY; 

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any root to reset it to right half of table.  (r resets all.)";
String author=  "Rebeca Janowicz";

float left, right, up, down;     // TABLE PERIMETER 
float middle= 250;
boolean wall = true, all false, mickey= false;
int pooltableR=23, pooltableG=85, pooltableB= 18;     // GREEN POOL TABLE 

// SETUP
void setup(){
   size(640,480);
  
     left= 50; right=450;
     up =500 ; down = 50; 
     middle= 250;
     
   reset();
}
void reset() {
//LOCATION OF BALLS
     rootX =  random(middle,left);        rootY= random(up,down);
     jamX =   random(middle,left);        jamY = random(up,down);
     voiceX = random(middle,left);        voiceY =random(up,down);
     
// SPEED OF BALLS
     rootDX =  random(1,4);        rootDY= random(1,4);
     jamDX =   random(1,4);        jamDY = random(1,4);
     voiceDX = random(1,4);        voiceDY=random(1,4);
}
  
  
  
void draw() {
      poolTable(left, right, up, down);
      bounce();
      balls();
}     

// SHOWING POOL TABLE      
void poolTable(float left, float right, float up, float down){
  
      background(245,171,111);
      rectMode(CORNERS);
      fill(pooltableR, pooltableG, pooltableB);
      strokeWeight(20);
      stroke(108,45,49);
      rect(left,right,up+100,down+50); 
  }  
  
//  WALL AT MIDDLE OF THE TABLE 
  if (wall) {
    float middle=  (right+left)/2;    
    stroke( 0, 127, 0 );
    line( middle,up+10, middle,down-10 );
  }
 //stroke(0);
 // strokeWeight(1);
}
  
// SHOW BALLS 
  void balls() {
      noStroke();
      fill(252,231,66);                      // YELLOW root
      ellipse( rootX,rootY,40,40);
      fill(27,31,170 );                      // BLUE root
      ellipse( jamX,jamY, 40,40 );
      fill(240,52,19);                       // RED root
      ellipse( voiceX,voiceY, 40,40 ); 
     
// BALLS NUMBERED      
      fill(0); 
      text('1', rootX, rootY);               
      text('2', jamX,jamY);
      text('3', voiceX,voiceY);
  }

//BALLS BOUNCE OF POOL TABLE  
  void bounce() {
    
      rootX += rootDX; if ( rootX < left || rootX > right )  rootDX *= -1; 
      rootY += rootDY; if ( rootY < up || rootY > down)      rootDY *=  -1;
      
      jamX += jamDX;   if ( jamX < left || jamX > right )    jamDX *= -1;
      jamY += jamDY;   if ( jamY < up || jamY > down)        jamDY *=  -1;
       
      voiceX += voiceDX;  if ( voiceX < left || voiceX  > right) voiceDX *= -1;
      voiceY += voiceDY;  if ( voiceY < up || voiceY > down)     voiceDY *=  -1;  
}
