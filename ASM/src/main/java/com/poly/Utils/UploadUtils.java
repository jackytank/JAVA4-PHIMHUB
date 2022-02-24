package com.poly.Utils;

import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadUtils {
    public static String processUploadField(String fieldName, HttpServletRequest req,
                                            String storedFolder, String storedFilename) throws ServletException, IOException {
        Part filePart = req.getPart(fieldName);

        if (filePart == null || filePart.getSize() == 0) {
            return "";
        }

        if (storedFolder == null) {
            storedFolder = "/uploads";
        }

        if (storedFilename == null) {
            storedFilename = Path.of(filePart.getSubmittedFileName()).getFileName().toString();
        }else {
            storedFilename += "." + FilenameUtils.getExtension(Path.of(
                    filePart.getSubmittedFileName()).getFileName().toString());
        }
        String uploadFolder = req.getServletContext().getRealPath(storedFolder);

        Path uploadPath = Paths.get(uploadFolder);

        if (!Files.exists(uploadPath)) {
            Files.createDirectory(uploadPath);
        }
        filePart.write(Paths.get(uploadPath.toString(), storedFilename).toString());
        return storedFilename;
    }

}
