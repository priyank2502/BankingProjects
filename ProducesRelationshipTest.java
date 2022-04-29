
public class ProducesRelationshipTest {

	public static void main(String[] args) {
		Forest f = new Forest();
		Tree t = f.growTree();
		Wood w = t.cutWood();
		Sangwan s = w.SangwanWood();
		Plywood p = s.cutPlywood();
		Furniture fur = p.makingFurniture();
	    fur.classicFurniture();
	
		 Furniture fur1 = new Forest().growTree().cutWood().SangwanWood().cutPlywood().makingFurniture();
		 fur1.classicFurniture();
		 
		 Decor decor = new Decor();
		 Furniture fur2= decor.shop();
		 Furniture fur3= decor.shop();
		 Furniture fur4= decor.shop();
		 Furniture fur5= decor.shop();
		 Furniture fur6= decor.shop();
		 fur6.classicFurniture();
		
	}

}

class Decor{
	Furniture shop() {
	Forest f = new Forest();
	Tree t = f.growTree();
	Wood w = t.cutWood();
	Sangwan s = w.SangwanWood();
	Plywood p = s.cutPlywood();
	Furniture fur = p.makingFurniture();
    return fur;
	}
	
	
}

class Forest {
	Tree growTree() {
		Tree t = new Tree();
		return t;
	}
}

class Tree extends Forest {
	Wood cutWood() {
		Wood w = new Wood();
		return w;
	}
}

class Wood {
	Sangwan SangwanWood() {
		Sangwan s = new Sangwan();
		return s;
	}
}

class Sangwan {
	Plywood cutPlywood() {
		Plywood p = new Plywood();
		return p;
	}
}

	class Plywood {
		Furniture makingFurniture() {
			Furniture f = new Furniture();
			return f;
			
		}
	}


class Furniture {
	 
	void classicFurniture() {
		System.out.println("Classic Furniture for your Home Decor....");
	}
}
