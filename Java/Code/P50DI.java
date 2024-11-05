public class P50DI {
    interface Chef {
        void prepareDish();
    }

    static class ItalianChef implements Chef {
        @Override
        public void prepareDish() {
            System.out.println("Preparing Italian dish!");
        }
    }

    static class FrenchChef implements Chef {
        @Override
        public void prepareDish() {
            System.out.println("Preparing French dish!");
        }
    }

    static class Restaurant {
        private Chef chef;

        public Restaurant(Chef chef) {
            this.chef = chef;
        }

        public void serveDish() {
            System.out.println("Welcome to the restaurant!");
            chef.prepareDish();
        }
    }

    public static void main(String[] args) {
        Chef italianChef = new ItalianChef();
        Restaurant italianRestaurant = new Restaurant(italianChef);
        italianRestaurant.serveDish();

        Chef frenchChef = new FrenchChef();
        Restaurant frenchRestaurant = new Restaurant(frenchChef);
        frenchRestaurant.serveDish();
    }
}
