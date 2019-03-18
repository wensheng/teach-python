import os
import random
import numpy as np
from PIL import Image
from keras.models import Sequential
from keras.layers import Dense
from keras.utils import to_categorical

zeros = []
ones = []

for f in os.listdir("train/0"):
    print("getting train/0/{}".format(f))
    img = Image.open("train/0/{}".format(f))
    data = np.array(img.getdata())
    data = 255 - data
    data = data // 255
    data = data.reshape((8,8))  # for demo, will change back to 64
    zeros.append(data)

for f in os.listdir("train/1"):
    print("getting train/1/{}".format(f))
    img = Image.open("train/1/{}".format(f))
    data = np.array(img.getdata())
    data = 255 - data
    data = data // 255
    data = data.reshape((8,8))
    ones.append(data)

train_data = [(a.astype(np.float32).reshape(64), 0) for a in zeros]
train_data += [(a.astype(np.float32).reshape(64), 1) for a in ones]

random.shuffle(train_data)

x = np.array([a[0] for a in train_data])
y = to_categorical([a[1] for a in train_data])

#raise ValueError


model = Sequential()
model.add(Dense(input_dim=64, activation='relu', units=100))
model.add(Dense(input_dim=100, activation='softmax', units=2))
model.compile(optimizer='adam', loss='categorical_crossentropy', metrics=['accuracy'])
print(model.summary())

model.fit(x,y, batch_size=2, epochs=15)

img = Image.open("test/test.bmp")
test_data = (255 - np.array(img.getdata())) // 255
test_data = test_data.astype(np.float32).reshape((1,64))
print(model.predict(test_data))
