package medium;

class Id1375 {
    public int numTimesAllBlue(int[] flips) {
        int rightMostFlippedBit=0;
        int count=0;
        for (int i=0; i<=flips.length-1; i++) {
            rightMostFlippedBit = Math.max(rightMostFlippedBit, flips[i]);
            //If we have reached the 1-index based idx of rightMostFlippedBit, surely all other bits before are flipped
            if (rightMostFlippedBit == i + 1) count++;
        }
        return count;
    }
}