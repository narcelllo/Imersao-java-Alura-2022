import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.awt.Font;

//import java.io.IOException;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria() throws Exception{

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("alura-stickers/entrada/image.png"));

        // cria nova imagem transparente e com tamanho novo 
        int largura = imagemOriginal.getWidth();
        int altura =  imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copia a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // config font
        var fonte = new Font(Font.SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);

        // escrever frase na imaem 
        graphics.setColor(Color.YELLOW);
        graphics.drawString("RUIM", 100, novaAltura - 100);
        // salvar em novo arquivo
        ImageIO.write(novaImagem, "png", new File("alura-stickers/saida/figurinha.png"));

    }
    
    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}
