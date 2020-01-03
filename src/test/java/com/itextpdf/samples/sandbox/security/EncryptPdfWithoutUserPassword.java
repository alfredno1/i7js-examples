/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2020 iText Group NV
    Authors: iText Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
/**
 * Example written by Bruno Lowagie in answer to:
 * http://stackoverflow.com/questions/27867868/how-can-i-decrypt-a-pdf-document-with-the-owner-password
 */
package com.itextpdf.samples.sandbox.security;

import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;

import java.io.File;

public class EncryptPdfWithoutUserPassword {
    public static final String DEST = "./target/sandbox/security/encrypt_pdf_without_user_password.pdf";
    public static final String SRC = "./src/test/resources/pdfs/hello.pdf";

    public static final String OWNER_PASSWORD = "World";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new EncryptPdfWithoutUserPassword().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(SRC),
                new PdfWriter(dest, new WriterProperties().setStandardEncryption(
                        // null user password argument is equal to empty string,
                        // this means that no user password required
                        null,
                        OWNER_PASSWORD.getBytes(),
                        EncryptionConstants.ALLOW_PRINTING,
                        EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA))
        );
        pdfDoc.close();
    }
}
