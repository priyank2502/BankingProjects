package com.sbi.demo.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sbi.demo.entity.Transaction;
import com.sbi.demo.entity.UserInput;


@Service
public class CreatePDFServiceImpl implements CreatePDFService {

	@Override
	public void createPdf(List<Transaction> txnList) throws Exception {
		// TODO Auto-generated method stub
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));

		document.open();

		PdfPTable table = new PdfPTable(6);
		addTableHeader(table);
		addRows(table,txnList);
		//addCustomRows(table);

		document.add(table);
		document.close();

	}
	private void addTableHeader(PdfPTable table) {
	    Stream.of("Date", "Narration", "RefNo","Withdrawal","Deposits","Account Balance")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(2);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	private void addRows(PdfPTable table,List<Transaction> txnList) {
		for(Transaction txn:txnList) {
	    table.addCell(txn.getDateOfTxn().toString());
	    table.addCell(txn.getNarration());
	    table.addCell(String.valueOf(txn.getTransactionNumber()));
	    if(txn.getTxnType()=="dr") {
	    	table.addCell(String.valueOf(txn.getTxnAmt()));
	    }
	    if(txn.getTxnType()=="cr") {
	    	table.addCell(String.valueOf(txn.getTxnAmt()));
	    }
	    table.addCell(String.valueOf(txn.getTxnBalance()));
	    
	}
	}
	/*private void addCustomRows(PdfPTable table) 
			  throws URISyntaxException, BadElementException, IOException {
			   /* Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
			    Image img = Image.getInstance(path.toAbsolutePath().toString());
			    img.scalePercent(10);

			    PdfPCell imageCell = new PdfPCell(img);
			    table.addCell(imageCell);*/

			  /*  PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
			    horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(horizontalAlignCell);

			    PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
			    verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
			    table.addCell(verticalAlignCell);
			}*/
}
