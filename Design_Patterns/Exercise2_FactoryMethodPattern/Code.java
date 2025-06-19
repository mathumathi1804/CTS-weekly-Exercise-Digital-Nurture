
interface Doc {
    void create();
}

class WordDoc implements Doc {
    public void create() {
        System.out.println("Word Document Created");
    }
}

class PdfDoc implements Doc {
    public void create() {
        System.out.println("PDF Document Created");
    }
}

class ExcelDoc implements Doc {
    public void create() {
        System.out.println("Excel Document Created");
    }
}

abstract class DocFactory {
    public abstract Doc getDocument();
}

class WordFactory extends DocFactory {
    public Doc getDocument() {
        return new WordDoc();
    }
}

class PdfFactory extends DocFactory {
    public Doc getDocument() {
        return new PdfDoc();
    }
}

class ExcelFactory extends DocFactory {
    public Doc getDocument() {
        return new ExcelDoc();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Document Factory");

        DocFactory f1 = new WordFactory();
        Doc d1 = f1.getDocument();
        d1.create();

        DocFactory f2 = new PdfFactory();
        Doc d2 = f2.getDocument();
        d2.create();

        DocFactory f3 = new ExcelFactory();
        Doc d3 = f3.getDocument();
        d3.create();
    }
}
