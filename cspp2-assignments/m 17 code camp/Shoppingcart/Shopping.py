# class Item:
# 	def __init__(self, productname, quantity, price):
# 		self.productname = productname
# 		self.quantity = quantity
# 		self.price = price
# 	def getPname(self):
# 		return self.productname
# 	def getQuantity(self):
# 		return self.quantity
# 	def getPrice(self):
# 		return self.price
# 	def displayItem(self):
# 		print(self.productname + " " + self.quantity + " " + str(float(self.price)))

# class ShoppingCart:
# 	catalog = []
# 	cart = []
# 	def __init__(self):
# 		pass
# 	def addToCatalog(self, Item):
# 		self.catalog.append(Item)
# 	# def addToCart(self, Item):
# 	def removeFromcart(self, Item):
# 		pass
# 	# def 

# def main():
	
# 	ip = int(input())
# 	for i in range(ip):
# 		data = input().split()
# 	# print(data[1])
# 		if data[0] == "Item":
# 			data1 = data[1].split(",")
# 			# print(data1)
# 		if data[0] == "catalog":
# 			item = Item(data1[0], data1[1], data1[2])
# 			print(item.displayItem())
global catalog
catalog = {}
global cart
cart = {}
def addCatalog(info):
    data = info.split(",")
    # print(data[0])
    if data[0] not in catalog:
        catalog[data[0]] = {data[1] : int(data[2])}

def displayCatalog():
    # print(catalog)
    for key,val in catalog.items():
        for k,v in val.items():
            print(key, k , float(v))

def addCart(info):
    data = info.split(",")
    # print(data)
    if data[0] not in cart:
        # cart = update({data[0] : data[1]})
        cart[data[0]] = int(data[1])
    else:
        cart[data[0]] += int(data[1])


def displayCart():
    for key,val in cart.items():
        print(key, val)

def totalAmount():
    # print()
    global amount
    amount = 0.0
    # quant = 
    for key,val in catalog.items():
        # print(key, "keyyyyyyyyy")
        for k,v in val.items():
            # print(k,type(v),"vallllllll")
            for k1,v1 in cart.items():
                # print(k1, v1, "cartttttttt")
                if k1 == key:
                    # print(v1)
                    # print(v)
                    amount += v1 * v
    print("totalAmount:", amount)

def payableAmount():
    global res
    global tax
    tax = 15 * amount/100
    res = tax + amount
    print("Payable amount: ",res)
    # print("Tax:",tax)

def remove(info):
    data = info.split(",")
#     # print(data)
    dummy = cart.copy()
    # print(dummy)
    for key,val in dummy.items():
        # print(key, "------" ,val)
        if key == data[0]:
            val -= int(data[1])
            cart[key] = val
        if val == 0:
            cart.pop(key)
            # print("Its me zerooooooo")
            # print(val,"kkkk")
                
# def discount(info):
#     # data = info.split(",")
#     # print(data)
#     if info == 'IND0':
#         discount = amount * 0.1
#         print(discount,"discount")



def display():
    print("Name   quantity   Price")
    for key,val in catalog.items():
        for k,v in val.items():
            for k1,v1 in cart.items():
                if k1 == key:
                    print(key, v1, float(v))

    print("Total:", amount)
    print("Disc%:", 0.0)
    print("Tax:",tax)
    print("Payable amount: ", res)

def main():
    lines = int(input())
    for x in range(lines):
        string = input().split(" ")
        # print(string[0])
        if string[0] == "Item":
            addCatalog(string[1])
        if string[0] == "catalog":
            displayCatalog()
        if string[0] == "add":
            addCart(string[1])
        if string[0] == "show":
            displayCart()
        if string[0] == "totalAmount":
            totalAmount()
        if string[0] == "remove":
            remove(string[1])
        if string[0] == "payableAmount":
            payableAmount()
        if string[0] == "print":
            display()
        if string[0] == "coupon":
            discount(string[1])
    # print(catalog)
    # print(cart)
if __name__ == '__main__':
    main()


# if __name__ == '__main__':
# 	main()