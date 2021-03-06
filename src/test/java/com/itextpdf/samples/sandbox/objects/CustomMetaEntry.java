/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2020 iText Group NV
    Authors: iText Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
/**
 * This example is written by Bruno Lowagie in answer to the following question:
 * http://stackoverflow.com/questions/26726485/itext-add-delete-retrieve-information-in-custom-property
 */
package com.itextpdf.samples.sandbox.objects;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;

public class CustomMetaEntry {
    public static final String DEST = "./target/sandbox/objects/custom_meta_entry.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CustomMetaEntry().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        pdfDoc.getDocumentInfo().setTitle("Some example");

        // Add metadata to pdf document
        pdfDoc.getDocumentInfo().setMoreInfo("MetadataName", "metadataValue");

        Paragraph p = new Paragraph("Hello World");
        doc.add(p);

        doc.close();
    }
}
