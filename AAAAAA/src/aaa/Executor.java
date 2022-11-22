package aaa;

public class Executor {
	public static void main(String[] args) {
       ArvoreBinaria ab = new ArvoreBinaria();
       ab.insere(20);
       ab.insere(21);
       ab.insere(13);
       ab.insere(11);
       ab.insere(12);
       ab.insere(14);
       
       System.out.println("Percurso pre-ordem");
       ab.preOrdem(ab.retornaRaiz());
//       System.out.println("Percurso em ordem: ");
//       ab.emOrdem(ab.retornaRaiz());
//       System.out.println("Percurso pos-ordem: ");
//       ab.posOrdem(ab.retornaRaiz());
       
//       System.out.println("Altura da árvore: " + ab.altura(ab.retornaRaiz()));
//       System.out.println("Quantidade de folhas: " + ab.folhas(ab.retornaRaiz()));
//       System.out.println("Quantidade de nos: " + ab.contaNos(ab.retornaRaiz()));
//       System.out.println("Valor mínimo: " + ab.valorMinimo().getValor());
//       System.out.println("Valor máximo: "+ ab.valorMaximo().getValor());
//       
       ab.remove(21);
       System.out.println("Pre-ordem sem o 21: ");
       ab.preOrdem(ab.retornaRaiz());
       
	}
}
