interface Picture {
void show();
}

class ActualPicture implements Picture {
    private String imageName;

    public ActualPicture(String imageName) {
        this.imageName = imageName;
        loadFromServer(imageName);
    }

    private void loadFromServer(String imageName) {
        System.out.println("Loading: " + imageName + " from server...");
    }

    public void show() {
        System.out.println("displaying: " + imageName);
    }
}

class PictureProxy implements Picture {
    private ActualPicture actualImage;
    private String imageName;

    public PictureProxy(String imageName) {
        this.imageName = imageName;
    }

    public void show() {
        if (actualImage == null) {
            actualImage = new ActualPicture(imageName);
        }
        actualImage.show();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Proxy Pattern Demo by Mathumathi");

        Picture picture1 = new PictureProxy("beach.jpg");
        picture1.show();
        picture1.show();

        Picture picture2 = new PictureProxy("flower.jpg");
        picture2.show();
    }
}
