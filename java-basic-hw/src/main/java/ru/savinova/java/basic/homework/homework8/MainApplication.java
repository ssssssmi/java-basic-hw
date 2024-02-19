package ru.savinova.java.basic.homework.homework8;

public class MainApplication {
    public static void main(String[] args) {
        String[][] array = {{"1", "1", "er", "1" }, {"1", "1", "1", "1" }, {"1", "1", "1", "1" }, {"1", "1", "1", "1" }};
        try {
            intAndSumm(array);
        } catch (AppArraySizeException | AppArrayDataException exp) {
            System.out.println(exp.getMessage());
        }
    }

    public static void intAndSumm(String[][] array) {
        if (array.length == 4) {
            for (String[] strings : array) {
                if (strings.length != 4) throw new AppArraySizeException("Размер массива не 4х4");
            }
        } else {
            throw new AppArraySizeException("Размер массива не 4х4");
        }
        int[][] numbers = new int[4][4];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    numbers[i][j] = Integer.parseInt(array[i][j]);
                    sum += numbers[i][j];
                } catch (NumberFormatException exception) {
                    throw new AppArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма элементов: " + sum);
    }
}