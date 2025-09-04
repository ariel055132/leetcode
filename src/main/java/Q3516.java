public class Q3516 {
    public int findClosest(int person1Pos, int person2Pos, int person3Pos) {
        int distanceBetweenXZ = Math.abs(person3Pos - person2Pos);
        int distanceBetweenYZ = Math.abs(person3Pos - person1Pos);
        if (distanceBetweenYZ > distanceBetweenXZ) {
            return 2;
        } else if (distanceBetweenYZ < distanceBetweenXZ) {
            return 1;
        } else {
            return 0;
        }
    }
}
