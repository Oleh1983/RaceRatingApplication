package ua.com.foxminded.raceratingapplication;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.racersorter.dao.DAO;

class DAOTest {

    @Test
    @DisplayName("Checks if file Abbreviations exists")
    void theMethodAbbreviationsLoaderFile_checksIfFileExists() throws IOException {
        
        String file = "abbreviations.txt";
        String parseAbbreviationsFile;
        
        try (InputStream abbreviationsFile = DAO.class.getClassLoader().getResourceAsStream(file)) {
            parseAbbreviationsFile = IOUtils.toString(abbreviationsFile, StandardCharsets.UTF_8);
        }

        assertNotNull("Could not find file " + file, parseAbbreviationsFile);
    }

    @Test
    @DisplayName("Chekcs if existing Abbreviations file is the same")
    void theMethodAbbreviationsLoaderFile_checksIfExistsFileTheSame() throws IOException {
        
        String file = "abbreviations.txt";
        String parseAbbreviationsFile;
        
        try (InputStream abbreviationsFile = DAO.class.getClassLoader().getResourceAsStream(file)) {
            parseAbbreviationsFile = IOUtils.toString(abbreviationsFile, StandardCharsets.UTF_8);
        }
        String exempleString = "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER\n"
                + "SVF_Sebastian Vettel_FERRARI\n"
                + "LHM_Lewis Hamilton_MERCEDES\n"
                + "KRF_Kimi Raikkonen_FERRARI\n"
                + "VBM_Valtteri Bottas_MERCEDES\n"
                + "EOF_Esteban Ocon_FORCE INDIA MERCEDES\n"
                + "FAM_Fernando Alonso_MCLAREN RENAULT\n"
                + "CSR_Carlos Sainz_RENAULT\n"
                + "SPF_Sergio Perez_FORCE INDIA MERCEDES\n"
                + "PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA\n"
                + "NHR_Nico Hulkenberg_RENAULT\n"
                + "SVM_Stoffel Vandoorne_MCLAREN RENAULT\n"
                + "SSW_Sergey Sirotkin_WILLIAMS MERCEDES\n"
                + "CLS_Charles Leclerc_SAUBER FERRARI\n"
                + "RGH_Romain Grosjean_HAAS FERRARI\n"
                + "BHS_Brendon Hartley_SCUDERIA TORO ROSSO HONDA\n"
                + "MES_Marcus Ericsson_SAUBER FERRARI\n"
                + "LSW_Lance Stroll_WILLIAMS MERCEDES\n"
                + "KMH_Kevin Magnussen_HAAS FERRARI\n";
        
        assertEquals(exempleString.replaceAll("\\s+","") , parseAbbreviationsFile.replaceAll("\\s+",""));
    }
    @Test
    @DisplayName("Checks if file Start exists")
    void theMethodStartLoaderFile_checksIfFileExists() throws IOException {

        String file = "start.log";
        String parseStartFile;

        try (InputStream startFile = DAO.class.getClassLoader().getResourceAsStream(file)) {
            parseStartFile = IOUtils.toString(startFile, StandardCharsets.UTF_8);
        }

        assertNotNull("Could not find file " + file, parseStartFile);
    }
    
    @Test
    @DisplayName("Chekcs if existing Start file is the same")
    void theMethodStartLoaderFile_checksIfExistsFileTheSame() throws IOException {
        
        String file = "start.log";
        String parseStartFile;
        
        try (InputStream startFile = DAO.class.getClassLoader().getResourceAsStream(file)) {
            parseStartFile = IOUtils.toString(startFile, StandardCharsets.UTF_8);
        }
        String exempleString = "SVF2018-05-24_12:02:58.917\n"
                + "NHR2018-05-24_12:02:49.914\n"
                + "FAM2018-05-24_12:13:04.512\n"
                + "KRF2018-05-24_12:03:01.250\n"
                + "SVM2018-05-24_12:18:37.735\n"
                + "MES2018-05-24_12:04:45.513\n"
                + "LSW2018-05-24_12:06:13.511\n"
                + "BHS2018-05-24_12:14:51.985\n"
                + "EOF2018-05-24_12:17:58.810\n"
                + "RGH2018-05-24_12:05:14.511\n"
                + "SSW2018-05-24_12:16:11.648\n"
                + "KMH2018-05-24_12:02:51.003\n"
                + "PGS2018-05-24_12:07:23.645\n"
                + "CSR2018-05-24_12:03:15.145\n"
                + "SPF2018-05-24_12:12:01.035\n"
                + "DRR2018-05-24_12:14:12.054\n"
                + "LHM2018-05-24_12:18:20.125\n"
                + "CLS2018-05-24_12:09:41.921\n"
                + "VBM2018-05-24_12:00:00.000\n";
        
        assertEquals(exempleString.replaceAll("\\s+","") , parseStartFile.replaceAll("\\s+",""));
    }
    @Test
    @DisplayName("Checks if file End exists")
    void theMethodEndLoaderFile_checksIfFileExists() throws IOException {

        String file = "end.log";
        String parseEndFile;

        try (InputStream endFile = DAO.class.getClassLoader().getResourceAsStream(file)) {
            parseEndFile = IOUtils.toString(endFile, StandardCharsets.UTF_8);
        }

        assertNotNull("Could not find file " + file, parseEndFile);
    }
    
    @Test
    @DisplayName("Chekcs if existing End file is the same")
    void theMethodEndLoaderFile_checksIfExistsFileTheSame() throws IOException {
        
        String file = "end.log";
        String parseEndFile;
        
        try (InputStream endFile = DAO.class.getClassLoader().getResourceAsStream(file)) {
            parseEndFile = IOUtils.toString(endFile, StandardCharsets.UTF_8);
        }
        String exempleString = "MES2018-05-24_12:05:58.778\n"
                + "RGH2018-05-24_12:06:27.441\n"
                + "SPF2018-05-24_12:13:13.883\n"
                + "LSW2018-05-24_12:07:26.834\n"
                + "DRR2018-05-24_12:15:24.067\n"
                + "NHR2018-05-24_12:04:02.979\n"
                + "CSR2018-05-24_12:04:28.095\n"
                + "KMH2018-05-24_12:04:04.396\n"
                + "BHS2018-05-24_12:16:05.164\n"
                + "SVM2018-05-24_12:19:50.198\n"
                + "KRF2018-05-24_12:04:13.889\n"
                + "VBM2018-05-24_12:01:12.434\n"
                + "SVF2018-05-24_12:04:03.332\n"
                + "EOF2018-05-24_12:19:11.838\n"
                + "PGS2018-05-24_12:08:36.586\n"
                + "SSW2018-05-24_12:17:24.354\n"
                + "FAM2018-05-24_12:14:17.169\n"
                + "CLS2018-05-24_12:10:54.750\n"
                + "LHM2018-05-24_12:19:32.585\n";
        
        assertEquals(exempleString.replaceAll("\\s+","") , parseEndFile.replaceAll("\\s+",""));
    }
}
