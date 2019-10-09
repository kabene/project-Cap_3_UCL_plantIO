
int photocellPin = 0; // the cell and 10K pulldown are connected to a0
int photocellReading; // the analog reading from the analog resistor divider
int second = 0;
int minute = 0;
int heure = 0;
int jour = 0;
char choseLue = Serial.read();

void setup(void) {
  Serial.begin(9600);
}

void loop(void) {
  Serial.print("Day:");
  Serial.print(jour);
  Serial.print(":");
  Serial.print("Hour:");
  Serial.print(heure);
  if (heure == 24 ) {
    heure = heure * 0;
    jour = (jour + 1);
  }
  Serial.print(":");
  Serial.print("Minute:");
  Serial.print(minute);
  if (minute == 59) {
    minute = minute * 0;
    heure = (heure + 1);
  }
  Serial.print(":");
  Serial.print("Sec:");
  Serial.print(second);
  if (second >60) {
    second = second * 0;
    minute = (minute + 1);
  } else {
    second = (second +1);
  }

  Serial.print("|");


  //if(interrup>0){
  photocellReading = analogRead(photocellPin);
  Serial.print("Luminosity= ");
  Serial.print(1024 - photocellReading ); //1024-sensor because the sensor inverse data
  Serial.print(" lux");

  if (photocellReading < 10) {
    Serial.println("-Extremely bright");
  } else if (photocellReading < 50) {
    Serial.println("-Very bright");
  } else if (photocellReading < 100) {
    Serial.println("-Bright");
  } else if (photocellReading < 500) {
    Serial.println("-Usual light");
  } else if (photocellReading < 1000) {
    Serial.println("-Dim");
  } else {
    Serial.println("-Dark");
  }
  delay(1000);



}


