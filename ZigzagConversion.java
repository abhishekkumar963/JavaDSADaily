// 6. Zigzag Conversion


class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
      
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int row = 0; row < numRows; row++) {
            rows[row] = new StringBuilder();
        }
      
        int currentRow = 0;
        int direction = -1;
      
        for (char character : s.toCharArray()) {
            rows[currentRow].append(character);
          
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction = -direction;
            }
          
            currentRow += direction;
        }
      
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
      
        return result.toString();
    }
}