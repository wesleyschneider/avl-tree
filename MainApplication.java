import java.util.Scanner;

public class MainApplication {
	static final int OPERATION_INSERT = 1;
	static final int OPERATION_DELETE = 2;
	static final int OPERATION_SEARCH = 3;
	static final int OPERATION_EXIT = 4;

	public static void main(String[] args) {
		System.out.println("\n\n------ AVL Tree - Estruturas Avançadas de Dados (Unisinos) ------\n\n");

		Scanner in = new Scanner(System.in);

		System.out.println("Qual numero deseja comecar a arvore?");
		int firstNodeKey = in.nextInt();

		var avlTree = new AvlTree(new Node(firstNodeKey));

		System.out.println("\nAVL Tree: " + avlTree);

		int operation;

		do {
			System.out.println(
					"\nQual operação deseja realizar:\n" +
							"(" + OPERATION_INSERT + ") Inserir\n" +
							"(" + OPERATION_DELETE + ") Deletar\n" +
							"(" + OPERATION_SEARCH + ") Buscar\n" +
							"(" + OPERATION_EXIT + ") Sair");
			operation = in.nextInt();

			switch (operation) {
				case OPERATION_INSERT -> {
				}
				case OPERATION_DELETE -> {
				}
				case OPERATION_SEARCH -> {
				}
				case OPERATION_EXIT -> {
					System.out.println("Saindo");
				}
				default -> System.out.println("O valor digitado é inválido, informe uma das opções!");
			}

		} while (operation != 4);
	}

}
