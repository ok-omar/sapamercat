package model;

public class LimitProductesException extends Exception{
        private Integer valor;


        public LimitProductesException(int numProductes) {
            valor = numProductes;
        }

        @Override
        public String toString() {
            return "Exception LimitProductesException: S'ha superat el límit de 100 productes al carret! Nombre de productes: " + valor.toString();
        }

}
