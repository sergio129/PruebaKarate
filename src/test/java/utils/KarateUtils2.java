package utils;//package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KarateUtils2 {
    public static void modificarArchivo() {
        String csvFile = "src/test/java/acceptance/test/datos/recaudoTemplateDatosCorrectos.csv";
        String line = "";
        String cvsSplitBy = ","; // El delimitador de tu CSV, usualmente es una coma
        List<String> lines = new ArrayList<>();
        String docNumberToSearch = "82954306"; // Aquí puedes poner el número de documento que estás buscando
        String newDueDate = "2000-01-01"; // Aquí puedes poner la nueva fecha de vencimiento
        String[] header = null;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            header = br.readLine().split(cvsSplitBy); // Leer la primera línea para obtener los nombres de las columnas
            while ((line = br.readLine()) != null) {
                // Usa la coma como separador
                String[] row = line.split(cvsSplitBy);

                // Buscar en la columna "Número de documento"
                if (row[getColumnIndex(header, "Número de documento")].equals(docNumberToSearch)) {
                    row[getColumnIndex(header, "Fecha de Vencimiento")] = newDueDate;
                    line = String.join(",", row); // Unir la fila modificada en una sola línea
                }
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Escribir las líneas (incluyendo las modificadas) de nuevo al archivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            bw.write(String.join(",", header)); // Escribir la primera línea (nombres de las columnas)
            bw.newLine();
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener el índice de una columna por su nombre
    public static int getColumnIndex(String[] header, String columnName) {
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(columnName)) {
                return i;
            }
        }
        return -1; // Devolver -1 si no se encuentra la columna
    }
}