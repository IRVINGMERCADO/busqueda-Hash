import java.lang.reflect.Array;
import java.util.Arrays;

public class hash {

    String[]arreglo;
    int tamaño, contador;
    public hash(int tam) {
        tamaño = tam;
        arreglo = new String[tam];
        Arrays.fill(arreglo, "-1");
    }
        public void funcionhash(String[]cadenarreglo,String[] arreglo){
        int i;
        for(i=0;i<cadenarreglo.length;i++){
            String elemento=cadenarreglo[i];
            int indicearreglo=Integer.parseInt(elemento)%7;
            System.out.println("el indice es " + indicearreglo+ " para el elemento o valor " +elemento);

            //tratando colisiones
            while (arreglo[indicearreglo]!="-1"){
                indicearreglo++;
                System.out.println("ocurrio una colision en el indice " + (indicearreglo-1)+ " cambiar indice  "+ indicearreglo);
                indicearreglo%=tamaño;

            }
            arreglo[indicearreglo]=elemento;
        }

    }
    //metodo para mostrar la tabla
    public  void  mostrar(){
            int incremento=0,i,j;
            for(i=0;i<1;i++){
                incremento+=8;
                for (j=0; j<71; j++){
                    System.out.println("-");

                }
                System.out.println();
                for (j=incremento-8; j<incremento; j++){
                    System.out.format("[ %3s "+" ", j);
                }
                System.out.println("]");
                for (int n=0; n<71; n++){
                    System.out.println("-");
                }
                System.out.println();
                for (j=incremento-8; j<incremento; j++){
                    if(arreglo[j].equals("-1")){
                        System.out.println("[       ");
                    }else {
                        System.out.print(String.format("[ %3s "+ "",arreglo));
                    }
                    System.out.println("[");
                    for (j=0; j<71; j++){
                        System.out.println("-");
                    }
                    System.out.println();
                }
            }
    }

    //metodo para buscar clave
    public String buscarclave(String[]elemento){
        int indicearreglo=Integer.parseInt(elemento)%7;
        int contador=0;
        while (arreglo[indicearreglo]!="-1"){
            if(arreglo[indicearreglo]==elemento){
                System.out.println("el elemento "+ elemento+  " fue encontardo ene l indice " + indicearreglo);
                return arreglo[indicearreglo];

            }
            indicearreglo++;
            indicearreglo%=tamaño;
            if(contador>7){
                break;
            }

        }
        return  null;
    }

public  static void  main(String[]args){
        hash h =new hash(8);
        String[]elementos={"20","33","21","10","12","14","56","100"};
        h.funcionhash(elementos,h.arreglo);
        h.mostrar();
        String buscado=h.buscarclave("33");
        if (buscado==null){
            System.out.println("elemento 33 no se encuentara en la tabla ");
        }
}



}

