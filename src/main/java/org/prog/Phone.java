package org.prog;

public class Phone {

    private boolean isDisplayTurnedOn;
    //TODO: read about java primitive data types
    private int volume;
    private boolean isLightTurnedOn;

    public void pressPowerButton() {
        if (isDisplayTurnedOn == true) {
            isDisplayTurnedOn = false;
        } else {
            isDisplayTurnedOn = true;
        }
        printState();
    }

    public void volumeUp() {
        if (volume < 10) {
            volume = volume + 1;
        }
        printState();
    }

    public void volumeDown() {
        if (volume > 0) {
            volume = volume - 1;
        }
        printState();
    }

    public void pressLightButton(){
        if(isLightTurnedOn){
            isLightTurnedOn = false;
        } else{
            isLightTurnedOn = true;
        }
        printState();
    }

    private void printState() {
        System.out.println("Phone display : " + isDisplayTurnedOn);
        System.out.println("Phone volume : " + volume);
        System.out.println("Phone light: " + isLightTurnedOn);
    }
}
