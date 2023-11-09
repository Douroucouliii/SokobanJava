with open('all.txt', 'r') as f:
    lines = f.readlines()

new_lines = []
for i, line in enumerate(lines):
    new_line = ""
    for j, char in enumerate(line):
        if char == " " and ("#" not in line[:j] or "#" not in line[j+1:]):
            new_line += "/"
        else:
            new_line += char
    new_lines.append(new_line)

with open('all2.txt', 'w') as f:
    f.writelines(new_lines)