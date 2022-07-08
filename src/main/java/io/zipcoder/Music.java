package io.zipcoder;

import javax.swing.*;

public class Music {

    private String[] playList;

    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
        int clickUp = 0;
        int clickDown = 0;


        //first for loop is to check click ups.
        //Outer for loop is to start at the index and ends at the end of array.
        //If selection is found, then break out of loop.
        //If selection is not found by end of loop, then nested for loop starts at index 0 and ends at startIndex.
        //If selection is found in nested, then break out of loop.
        //This means we are looping through the whole array.

        for (int i = startIndex; i < playList.length; i++) {
            if (!playList[i].equals(selection)) {
                clickUp++;
            } else break;
            if (i == playList.length - 1) {
                for (int j = 0; j < startIndex; j++) {
                    if (!playList[j].equals(selection)) {
                        clickUp++;
                    } else break;
                }
            }
        }

        //second for loop is to check click downs.
        //Outer for loop is to start at the index and ends at the beginning of array.
        //If selection is found, then break out of loop.
        //If selection is not found by end of loop, then nested for loop starts at end of array (length-1) and ends at startIndex.
        //If selection is found in nested, then break out of loop.
        //This means we are looping through the whole array.

        for (int i = startIndex; i >= 0; i--) {
            if (!playList[i].equals(selection)) {
                clickDown++;
            } else break;
            if (i == 0) {
                for (int j = playList.length-1; j > startIndex; j--) {
                    if (!playList[j].equals(selection)) {
                        clickDown++;
                    } else break;
                }
            }
        }
        return Math.min(clickUp,clickDown);
    }
}






