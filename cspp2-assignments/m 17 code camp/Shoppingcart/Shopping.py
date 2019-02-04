class Item:
	def __init__(self, productname, quantity, price):
		self.productname = productname
		self.quantity = quantity
		self.price = price
	def getPname(self):
		return self.productname
	def getQuantity(self):
		return self.quantity
	def getPrice(self):
		return self.price
	def displayItem(self):
		print(self.productname + " " + self.quantity + " " + str(float(self.price)))

class ShoppingCart:
	catalog = []
	cart = []
	def __init__(self):
		pass
	def addToCatalog(self, Item):
		self.catalog.append(Item)
	# def addToCart(self, Item):
	def removeFromcart(self, Item):
		pass
	# def 

def main():
	
	ip = int(input())
	for i in range(ip):
		data = input().split()
		# print(data[1])
		if data[0] == "Item":
			data1 = data[1].split(",")
			# print(data1)
		if data[0] == "catalog":
			item = Item(data1[0], data1[1], data1[2])
			print(item.displayItem())


if __name__ == '__main__':
	main()