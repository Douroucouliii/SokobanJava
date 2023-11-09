file_count = 4

with open("allmap.txt", "r") as f:
    contents = f.readlines()

    start_idx = 0
    for i, line in enumerate(contents):
        if line.strip() == "":
            filename = f"map{file_count}.txt"
            with open(filename, "w") as new_file:
                new_file.writelines(contents[start_idx:i])
            start_idx = i + 1
            file_count += 1

    filename = f"map{file_count}.txt"
    with open(filename, "w") as new_file:
        new_file.writelines(contents[start_idx:])