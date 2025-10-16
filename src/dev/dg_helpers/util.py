import colour

def log(message:str):
    print(f"{colour.YELLOW}[DataGen::INFO]{colour.RESET} {message}")

def log_warn(message:str):
	print(f"{colour.YELLOW}[DataGen::{colour.ORANGE}WARN{colour.YELLOW}] {message}")
