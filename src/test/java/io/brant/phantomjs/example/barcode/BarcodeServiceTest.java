package io.brant.phantomjs.example.barcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BarcodeServiceTest {

	@Autowired
	private BarcodeService barcodeService;

	@Test
	public void barcodeTest() throws IOException {
		BufferedImage barcode = barcodeService.barcode("brantplate::5234");

		ImageIO.write(barcode, "png", new File("test/barcode.png"));
	}

	@Test
	public void qrCodeTest() throws IOException, InterruptedException {
		BufferedImage barcode = barcodeService.qrCode("brantplate::5234");

		ImageIO.write(barcode, "png", new File("test/qrcode.png"));
	}
}