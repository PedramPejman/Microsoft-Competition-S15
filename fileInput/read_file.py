fp = open('input.txt', 'r')
contents = []
for l in fp:
  contents.append(l)
fp.close()


print(contents)
