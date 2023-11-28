package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CheckFilesFromArchive {
    private ClassLoader cl = CheckFilesFromArchive.class.getClassLoader();
    private String archiveFile = "TestFiles.zip";

    @DisplayName("Распаковка и проверка CVS из архива ZIP ")
    @Test
    void zipCvsFileTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream(archiveFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> csvContent = csvReader.readAll();
                    assertThat(csvContent.get(1)).contains(new String[]{";Marksa;;(955) 656-5656;;Email;;"});
                    return;
                }
            }
            fail("Отсутствует в архиве csv файл");
        }
    }

    @DisplayName("Распаковка и проверка PDF из архива ZIP ")
    @Test
    void zipPdfFileTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream(archiveFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat(pdf.text).contains("Item # Description Qty Unit Price Discount Price");
                    return;
                }
            }
            fail("Отсутствует в архиве pdf файл");
        }
    }

    @DisplayName("Распаковка и проверка XLS из архива ZIP ")
    @Test
    void zipXlxFileTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream(archiveFile))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains(".xlsx")) {
                    XLS xls = new XLS(zis);
                    assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(1)
                            .getStringCellValue()).isEqualTo("Test Company");

                    return;
                }
            }
            fail("Отсутствует в архиве xls файл");
        }
    }

}
