public class GeneraCurp{
    public static void main(String[] args){        
        List <String> curps  = new ArrayList<String>();
        
        int num = Integer.parseInt(args[0]);
        String curp_generado = "";
        String letras_curp_generado="";
        String letras_curp_iteracion="";
        int contador=0;
        Iterator<String> iterador;
            for(int i = 0; i < num; i++){
                curp_generado = getCURP();    
                System.out.println("CURP generado: "+curp_generado);
                
                letras_curp_generado=curp_generado.substring(0,4);
                iterador=curps.iterator();
                //Si es la primera iteración del ciclo for, entonces inserta directo el curp generado porque no hay elementos en el ArrayLists
                if(i==0){
                    curps.add(curp_generado);
                }
                else{
                    //Ciclo While del iterador
                    while(iterador.hasNext()){
                        
                        letras_curp_iteracion=iterador.next().substring(0,4);
                        //Si las 4 letras del curp de la iteración son mayores lexicográficamente que las 4 del curp generado,
                        //entonces se inserta el curp generado en la posición del curp de la iteración (se recorren los elementos, ninguno se elimina)
                        if(letras_curp_generado.compareTo(letras_curp_iteracion)<=0){
                            curps.add(contador,curp_generado);
                            break;
                        }
                        //Si el tamaño del ArrayList es igual al del contador, entonces se inserta el curp generado al final del ArrayList por defecto. 
                        else if((curps.size()-1) == contador){
                            curps.add(curp_generado);
                            break;
                        }
                        
                        contador++;
                    }
                }
                contador=0;
            }
            System.out.println("\nArrayList acomodado: \n");
            for(String curp:curps){
                System.out.println(curp);
            }
    }
}
